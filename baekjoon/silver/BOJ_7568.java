package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            people[i][0] = w;
            people[i][1] = h;
        }
        br.close();

        // 비교
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue; // 자신 제외

                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    count++;
                }
            }
            sb.append(count).append(" ");
        }
        System.out.print(sb);
    }

}
