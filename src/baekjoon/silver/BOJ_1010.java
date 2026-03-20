package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long[][] D = new long[31][31];
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) D[i][j] = 1;
                else D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(D[m][n]).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
