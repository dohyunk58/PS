package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // 루트 b 까지 소수 구하기 (에라토스테네스의 체)
        int rootB = (int)Math.sqrt(b);
        boolean[] isPrime = new boolean[rootB + 1];
        for (int i = 2; i <= rootB; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= rootB; i++) {
            if (!isPrime[i]) continue;

            // i만큼 증가하며 해당 숫자를 0으로 만들기
            for (int j = i*2; j <= rootB; j = j + i) {
                isPrime[j] = false;
            }
        }

        long count = 0;
        // 소수를 제곱하여 거의 소수 구하기
        for (int i = 2; i <= rootB; i++) {
            if (isPrime[i]) {
                long temp = i;

                // temp * i <= B 이나, 오버플로우되면 temp의 값이 작아지므로
                // i <= B / temp로 곱셈 연산을 하지 않고 결과가 b를 넘기지 않도록 연산함
                while ((double)i <= (double)b / temp) {
                    temp *= i;
                    if (temp >= a) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}
