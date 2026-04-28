package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] D = new int[n+2]; // 1일부터 i일까지의 최대 수익 (퇴사하는 n+1일까지)
        int[] T = new int[n+1]; // i일 상담 기간
        int[] P = new int[n+1]; // i일 상담 수익

        for (int i = 1; i<= n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        /* 처음에 했던 것(전방향): 1일차부터 상담을 하는 경우와 하지 않는 경우를 고려하며 값 저장
        for (int i = 1; i <= n; i++) {
            D[i+1] = Math.max(D[i+1], D[i]); // 상담을 쉬는 경우
            if (i + T[i] <= n + 1) D[i+T[i]] = Math.max(D[i+T[i]], D[i] + P[i]); // 상담을 하는 경우, i+T[i]일의 수익과 비교
        }
         */

        // 후방향,

        System.out.print(D[n+1]);
    }
}
