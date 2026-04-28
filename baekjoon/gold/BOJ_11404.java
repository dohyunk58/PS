package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] length = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) length[i][j] = 0;
                else length[i][j] = MAX;
            }
        }

        // edge 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (length[start][end] == MAX || length[start][end] > weight) length[start][end] = weight;
        }
        br.close();

        // 플로이드 워셜 알고리즘
        // 모든 노드를 중간점으로 length[start][end] = min(length[start][k] + length[k][end])
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    length[s][e] = Math.min(length[s][e], length[s][k] + length[k][e]);
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (length[i][j] == MAX) sb.append("0 ");
                else sb.append(length[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
