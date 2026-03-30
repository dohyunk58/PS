package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[][] D = new int[n+1][10]; // D[i][a]: 길이가 i이고 끝자리가 a인 계단수의 개수

        // 초기값
        D[1][0] = 0;
        for (int i = 1; i <= 9; i++) D[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            D[i][0] = D[i-1][1]; // 0이 올 수 있는 경우는 i-1길이의 계단 수 중 1로 끝나는 경우만 가능
            D[i][9] = D[i-1][8]; // 9는 8로 끝나는 경우
            for (int j = 1; j <= 8; j++) { // 나머지 a(1~8)은 a-1, a+1로 끝나는 경우
                D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1_000_000_000;
            }
        }

        // n번째 게단수 출력
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + D[n][i]) % 1_000_000_000;
        }

        System.out.print(result);
    }
}
