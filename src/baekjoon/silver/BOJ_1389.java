package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final int MAX = 5001;

        int[][] length = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) length[i][j] = 0;
                else length[i][j] = MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            length[a][b] = 1;
            length[b][a] = 1;
        }

        // 비용 1인 floyd-warshall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n ;i++) {
                for (int j = 1; j <= n; j++) {
                    length[i][j] = Math.min(length[i][j], length[i][k] + length[k][j]);
                }
            }
        }

        // 각 인원의 거리 합
        int minIndex = 0;
        int minSum = MAX;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i] += length[i][j];
            }
            if (sum[i] < minSum) {
                minSum = sum[i];
                minIndex = i;
            }
        }

        System.out.print(minIndex);
    }
}
