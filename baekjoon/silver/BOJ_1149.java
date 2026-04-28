package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// i번째 집을 j색으로 칠할 때 최소 비용: i-1번째 집을 j가 아닌 다른 두 색으로 칠했을 때의 최소 비용 중 작은 값에 현재 집의 비용을 더한 값
public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] houses = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sums = new int[n+1][3];
        // 각 집에서 가장 적은 비용으로 칠할 수 있는 것을 고르기
        for (int i = 1; i <= n; i++) {
            // 3가지 색상에 대해서 각 색상과 겹치지 않는 최소 비용을 골라 저장
            for (int j = 0; j < 3; j++) {
                // 자신 이외의 색상
                int a = 0; int b = 0;
                if (j == 0) {
                    a = 1; b = 2;
                } else if (j == 1) {
                    a = 0; b = 2;
                } else {
                    a = 0; b = 1;
                }

                // 같은 색상 이외의 더 적은 비용의 색상으로 이전 색 고르기
                int minCost = Math.min(sums[i-1][a], sums[i-1][b]);
                sums[i][j] = minCost + houses[i][j];
            }
        }

        int result = sums[n][0];
        result = Math.min(result, Math.min(sums[n][1], sums[n][2]));

        System.out.print(result);
    }
}
