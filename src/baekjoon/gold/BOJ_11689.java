package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = n;

        // n까지의 소수 중 n의 소인수를 찾아 P[i] = P[i] - P[i] / k
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result = result - result / i;

                // 소인수의 배수에서 중복 연산하지 않도록 소인수 i를 n에서 제거
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        // 루트 n 보다 큰 소수가 n의 소인수일때
        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}