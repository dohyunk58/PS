package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int n, m;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int startX = 0;
        int startY = 0;

        graph = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;

                // 목표점 처리
                if (graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (graph[i][j] == 0) { // 연결 처리
                    dist[i][j] = 0;
                }
            }
        }
        br.close();

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = dx[i] + now[0];
                int nowY = dy[i] + now[1];

                // 범위 안인지 확인
                if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < m) {
                    // 접근 가능하면 거리 변경
                    if (dist[nowX][nowY] == -1 && graph[nowX][nowY] == 1) {
                        dist[nowX][nowY] = dist[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nowX, nowY});
                    }
                }
            }
        }
    }
}
