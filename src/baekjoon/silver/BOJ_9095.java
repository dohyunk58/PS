package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            int[] visited = new int[num+3];
            visited[1] = 1;
            visited[2] = 2;
            visited[3] = 4;

            for (int j = 4; j <= num; j++) {
                visited[j] = visited[j-1] + visited[j-2] + visited[j-3];
            }

            sb.append(visited[num]).append("\n");
        }

        System.out.print(sb);
    }
}