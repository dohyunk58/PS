package baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2342 {
    static int INF = 100_001 * 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] weight = {{1, 2, 2, 2, 2},
                {INF, 1, 3, 4, 3},
                {INF, 3, 1, 3, 4},
                {INF, 4, 3, 1, 3},
                {INF, 3, 4, 3, 1}}; // weight[i][j]: i일때 j로 이동하는 경우 비용

        int[][][] dp = new int[100_001][5][5]; // dp[i][j][k]: i번째에 발이 j번과 k번에 있을 경우 최소 누적 비용
        // 큰 값으로 초기화
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }
        dp[0][0][0] = 0;

        /*
        n번째에서 왼발 오른발이 L, R일때의 최소값은 n-1번째의 두 가지 경로에서 올 수 있음
        1. n-1번째에서 왼발이 L의 위치로 이동한 경우: dp[n][L][R] = dp[n-1][L'][R] + weight[L'][L]
        2. n-1번째에서 오른발이 R의 위치로 이동한 경우: dp[n][L][R] = dp[n-1][L][R'] + weight[R'][R];
         */

        int n = 0; // 발을 움직인 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            n++;

            // n-1번째에서 왼발 오른발의 위치에 올 수 있는 최소값 찾기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int prevWeight = dp[n-1][i][j];
                    if (prevWeight == INF) continue; // 도달 불가
                    // n-1번째에서 왼발을 움직이는 경우
                    if (num != j) { // 가려는 곳이 오른발과 겹치지 않을 때
                        dp[n][num][j] = Math.min(prevWeight + weight[i][num], dp[n][num][j]);
                    }

                    // n-1번째에서 오른발을 움직이는 경우
                    if (num != i) {
                        dp[n][i][num] = Math.min(prevWeight + weight[j][num], dp[n][i][num]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, dp[n][i][j]);
            }
        }
        System.out.print(result);
    }
}
