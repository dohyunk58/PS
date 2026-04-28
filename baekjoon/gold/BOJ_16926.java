package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    static int[] dr = {1, 0, -1, 0}; // 하 우 상 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] M = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 레이어만큼 반복해 한 레이어의 요소를 1차원 배열에 저장 후 새 배열에 회전 수만큼 말어서 배치
        int L = Math.min(n, m) / 2; // 레이어 수
        int[][] newM = new int[n][m];
        for (int i = 0; i < L; i++) {
            int materialNum = 2*(n-i*2+m-i*2)-4; // 레이어별 요소 수
            int[] numbers = new int[materialNum];

            // 레이어 경계값
            int rMin = i;
            int rMax = n - 1 - i;
            int cMin = i;
            int cMax = m - 1 - i;

            // 레이어 요소 저장
            int row = rMin; int col = cMin;
            int dir = 0;
            for (int j = 0; j < materialNum; j++) {
                numbers[j] = M[row][col];

                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 범위 확인
                if (nr < rMin || nr > rMax || nc < cMin || nc > cMax) {
                    dir = (dir + 1)  % 4;
                    nr = row + dr[dir];
                    nc = col + dc[dir];
                }

                row = nr;
                col = nc;
            }

            // 새 배열에 회전 수만큼 밀어서 배치
            int realR = r % materialNum; // 실제 회전수

            row = rMin;
            col = cMin;
            dir = 0;

            for (int j = 0; j < materialNum; j++) {
                // 회전 수만큼 이전의 값을 가져와 배치하기
                int targetIndex = (j - realR + materialNum) % materialNum;
                newM[row][col] = numbers[targetIndex];

                int nr = row + dr[dir];
                int nc = col + dc[dir];

                if (nr < rMin || nr > rMax || nc < cMin || nc > cMax) {
                    dir = (dir + 1) % 4;
                    nr = row + dr[dir];
                    nc = col + dc[dir];
                }

                row = nr;
                col = nc;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(newM[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
