package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] fib = new int[41][2];
        fib[0] = new int[]{1, 0};
        fib[1] = new int[]{0, 1};
        for (int i = 2; i <= 40; i++) {
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
        }

        int t = Integer.parseInt(br.readLine());
        int n = 0;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(fib[n][0]).append(" ").append(fib[n][1]).append("\n");
        }
        System.out.print(sb);
    }
}
