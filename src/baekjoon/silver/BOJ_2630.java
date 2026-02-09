package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static boolean[][] matrix;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        matrix = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                matrix[i][j] = st.nextToken().equals("1");
            }
        }

        partition(0, 0, n);

        System.out.print(white + "\n" + blue);
    }

    static void partition(int x, int y, int size) {
        // 현재 구역 색상 확인
        if (isSameColor(x, y, size)) {
            if (matrix[x][y]) blue++;
            else white++;
            return;
        }

        // 색상이 다르다면 4등분
        int half = size / 2;

        // 좌상, 좌하, 우상, 우하
        partition(x, y, half);
        partition(x + half, y, half);
        partition(x, y + half, half);
        partition(x + half, y + half, half);
    }

    // x,y에서 size x size 만큼 크기에 모든 색이 같은지 확인
    static boolean isSameColor(int x, int y, int size) {
        boolean firstColor = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != firstColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
