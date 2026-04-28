package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static int[][] maze;
    public static int[][] depth;
    // 상하좌우 이동시 변동값
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        depth = new int[n][m];

        // 미로 입력
        for (int i = 0; i < n; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = numbers.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.print(depth[n-1][m-1]);
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        depth[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 1. 범위를 벗어나지 않고 2. 벽이 아니며(값이 1) 3. 방문하지 않은 경우(depth 0)
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maze[nx][ny] == 1 && depth[nx][ny] == 0) {
                        depth[nx][ny] = depth[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
