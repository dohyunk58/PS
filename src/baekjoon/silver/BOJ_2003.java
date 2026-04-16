package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] s = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }
        br.close();

        int front = 0;
        int end = 0;
        int count = 0;
        while (end <= n) {
            int sum = s[end] - s[front];

            if (sum == m) {
                count++;
                end++;
            } else if (sum < m) {
                end++;
            } else {
                front++;
            }
        }

        System.out.print(count);
    }
}
