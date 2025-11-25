package baekjoon.bronze;

/*
N이 소수가 아닐 때, N = a x b라고 한다면 a나 b 중에 하나는 루트N보다 작거나 같아야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i = 0; i < n; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number == 1) {
                continue;
            }

            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(number); j++) {
                if (number % j == 0) {
                    isPrime = false;
                }
            }

            if(isPrime) {
                count++;
            }
        }

        System.out.println(count);
    }
}