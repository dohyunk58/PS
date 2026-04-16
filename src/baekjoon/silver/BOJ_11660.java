package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1]; // s[i][j]: [0][0]-[i][j]까지의 부분합

        // s[i][j]: 위쪽까지의 합 + 왼쪽까지의 합 - 위쪽과 왼쪽 중복 영역 + ij번째 값
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + numbers[i][j];
            }
        }

        // a,b 에서 c,d까지의 합: s[c][d] - (s[c][b-1] + s[a-1][d] - s[a-1][b-1])
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int result = s[c][d] - (s[c][b-1] + s[a-1][d] - s[a-1][b-1]);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
