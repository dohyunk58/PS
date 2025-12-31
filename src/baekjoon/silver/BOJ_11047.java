package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int remain = k; int cnt = 0;
        for (int i = n-1; i >= 0; i--) {
            if (remain == 0) break;

            while (remain >= coins[i]) {
                cnt += (remain / coins[i]);
                remain = remain % coins[i];
            }
        }

        System.out.print(cnt);
    }
}
