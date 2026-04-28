package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    static int n;
    static int[][] m;
    static int[][] numbers;

    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = new int[n][n];
        numbers = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n ; j++) {
                m[i][j] = line[j] - '0';
            }
        }

        int cnt = 1;
        List<Integer> numberCnt = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 1 && numbers[i][j] == 0) {
                    numberCnt.add(bfs(i, j, cnt));
                    cnt++; // 탐색 후 단지 개수 추가 (개수 출력 시에는 -1해야함)
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(cnt-1).append("\n");
        Collections.sort(numberCnt);
        for(int i : numberCnt) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int startX, int startY, int number) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        numbers[startX][startY] = number;
        int numberCnt = 1; // 그룹 내 요소 수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 확인
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (m[nr][nc] != 0 && numbers[nr][nc] == 0) { // 연결 및 미방문 확인
                        queue.add(new int[]{nr, nc});
                        numbers[nr][nc] = number;
                        numberCnt++;
                    }
                }
            }
        }

        return numberCnt;
    }
}
