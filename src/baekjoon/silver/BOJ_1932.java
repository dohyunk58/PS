package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n]; // dp[i][j]: [i][j]번째 자리의 최대 누적합
        // dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j-1 < 0) { // 맨 왼쪽
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else if (j == i) { // 맨 오른쪽
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[n-1][i]);
        }
        System.out.print(result);
    }
}
