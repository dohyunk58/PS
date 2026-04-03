package groom.L2;

import java.io.*;
import java.util.*;

public class groom_195694 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] M;
    static int n;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        M = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    find(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    static void find(int row, int column) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, column});
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                // 범위 내
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    // 집이 있고 방문하지 않은 경우
                    if (M[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
