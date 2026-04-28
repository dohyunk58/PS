package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int cnt;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;
    static boolean[][] farm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            farm = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                farm[x][y] = true;
            }

            cnt = 0;
            visited = new boolean[n][m];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (!visited[x][y] && farm[x][y]) {
                        bfs(x, y); cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 범위
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 방문하지 않았고 배추 존재
                    if (!visited[nx][ny] && farm[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
