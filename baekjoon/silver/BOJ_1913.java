package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    static int[] dr = {1, 0, -1, 0}; // 하 우 상 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int findNum = Integer.parseInt(br.readLine());

        br.close();

        int[][] M = new int[n][n];

        int r = 0;
        int c = 0;
        int direction = 0;
        int findR = -1;
        int findC = -1;
        for (int i = n*n; i >= 1; i--) {
            // 배치
            M[r][c] = i;

            if (i == findNum) {
                findR = r + 1;
                findC = c + 1;
            }

            if (i == 1) break;

            // 다음칸
            int nr = r + dr[direction];
            int nc = c + dc[direction];

            // 배치 불가능한 경우 방향 전환
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || M[nr][nc] != 0) {
                direction = (direction + 1) % 4;

                nr = r + dr[direction];
                nc = c + dc[direction];
            }

            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(M[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(findR).append(" ").append(findC);
        System.out.print(sb);
    }
}
