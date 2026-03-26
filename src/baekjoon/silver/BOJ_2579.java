package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n+1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] maxScore = new int[n+1]; // 계단 별 최대 점수
        maxScore[1] = score[1];
        if (n >= 2) maxScore[2] = score[1] + score[2];
        if (n >= 3) maxScore[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        // 2칸을 뛰어 오거나 i-3 -> i-1 에서 한 칸을 뛰어오는 경우 중 큰 값을 고르기
        for (int i = 4; i <= n; i++) {
            maxScore[i] = Math.max(maxScore[i-2] + score[i], maxScore[i-3] + score[i-1] + score[i]);
        }

        System.out.print(maxScore[n]);
    }
}
