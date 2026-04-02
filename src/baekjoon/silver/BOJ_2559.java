package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0;
        int end = front + k - 1;
        int sum = 0;

        // 초기 k개의 수열 합 계산
        for (int i = front; i <= end; i++) {
            sum += temps[i];
        }

        int max = sum;
        while (end < n - 1) {
            // 앞부분 제거
            sum -= temps[front];
            front++;
            // 뒷부분 추가
            end++;
            sum += temps[end];
            // 최대값 확인
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}
