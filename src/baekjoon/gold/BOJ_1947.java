package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        long[] d = new long[n+1];
        d[0] = 0;
        d[1] = 0;
        if (n >= 2) d[2] = 1;

        for (int i = 3; i <= n; i++) {
            d[i] = ((i-1) * (d[i-1] + d[i-2])) % 1_000_000_000;
        }

        System.out.print(d[n]);
    }
}
