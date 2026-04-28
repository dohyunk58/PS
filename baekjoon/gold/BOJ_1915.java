package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1]; // dp[i][j]: i,j 위치일때 가장 큰 정사각형 한 변 길이

        int max = 0;
        for (int i = 1; i <= n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                int number = line[j-1] - '0';
                // 해당 자리가 1인 경우
                if (number == 1) {
                    // 상, 좌, 대각선 중 가장 작은 값을 가져온다(0이 있다면 현재 자리에서 다시 1부터 시작하는 것)
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(dp[i][j], max);
                } else { // 자리가 0인 경우 그 자리에서는 정사각형이 될 수 없으므로 0을 저장
                    dp[i][j] = 0;
                }
            }
        }

        System.out.print(max * max);
    }
}
