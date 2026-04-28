package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] answer = new int[num+1];
        answer[1] = 0;

        for (int i = 2; i <= num; i++) {
            // 1을 빼는 경우
            answer[i] = answer[i-1] + 1;
            // 2로 나누는 경우
            if (i % 2 == 0) answer[i] = Math.min(answer[i], answer[i/2] + 1);
            // 3으로 나누는 경우
            if (i % 3 == 0) answer[i] = Math.min(answer[i], answer[i/3] + 1);
        }

        System.out.print(answer[num]);
    }
}
