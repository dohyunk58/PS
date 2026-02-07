package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[m][n]; // W true, B false

        // 입력
        for (int i = 0; i < m; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 'W') board[i][j] = true;
            }
        }

        int minResult = 64;
        // 모든 8x8 시작점 탐색
        for (int i = 0; i <= m - 8; i++) {
            for (int j = 0; j <= n - 8; j++) {
                int count = 0;

                // 8x8 검사
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        // 시작 흰색 기준, x+y가 짝수면 흰색, 홀수면 검정
                        boolean expected = ((x + y) % 2 == 0);

                        if (board[x][y] != expected) {
                            count++;
                        }
                    }
                }

                // 흰색/검은색 시작일 때 칠해야하는 숫자 중 작은값 선택
                int result = Math.min(count, 64 - count);
                minResult = Math.min(minResult, result);
            }
        }

        System.out.print(minResult);
    }
}
