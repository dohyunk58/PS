package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] M = new boolean[101][101];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = x1 + 10;
            int y1 = Integer.parseInt(st.nextToken());
            int y2 = y1 + 10;

            for (int row = y1; row < y2; row++) {
                for (int col = x1; col < x2; col++) {
                    if (M[row][col] == false) {
                        M[row][col] = true;
                        sum++;
                    }
                }
            }
        }

        System.out.print(sum);
    }
}
