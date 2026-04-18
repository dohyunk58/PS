package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = numbers[1];
        int[] sum = new int[n+1]; // i번째를 포함한 가장 큰 누적합
        for (int i = 1; i <= n; i++) {
            sum[i] = Math.max(sum[i-1] + numbers[i], numbers[i]); // 이전까지의 합에서 합한것과 이번 값 중 큰 값을 선택
            result = Math.max(result, sum[i]);
        }

        System.out.print(result);
    }
}
