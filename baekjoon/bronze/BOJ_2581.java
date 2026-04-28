package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[m+1];
        for (int i = 2; i <= m; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        int min = -1;
        for (int i = n; i <= m; i++) {
            if (isPrime[i]) {
                sum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.print(sum+"\n"+min);
        }
    }
}
