package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int size = c * r;
        int k = Integer.parseInt(br.readLine());
        br.close();

        if (k > size) {
            System.out.print(0);
            return;
        }

        // 우측으로 90도 회전
        int[][] M = new int[c][r];

        int row = 0; int column = 0;
        int direction = 0;
        for (int i = 1; i <= size; i++) {
            if (i == k) {
                System.out.print((row+1) + " " + (column+1));
                return;
            }

            M[row][column] = i;

            int nr = row + dr[direction];
            int nc = column + dc[direction];

            // 범위를 넘어가거나 이미 배치된 경우 방향 변경
            if (nr < 0 || nr >= c || nc < 0 || nc >= r || M[nr][nc] != 0) {
                direction = (direction + 1) % 4;
                nr = row + dr[direction];
                nc = column + dc[direction];
            }

            row = nr;
            column = nc;
        }
    }
}
