package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] D = new int[n + 1];
        D[1] = 1;
        if (n >= 2) D[2] = 3;

        // 1칸 남은 상황 -> 2x1만 놓을 수 있음
        // 2칸 남은 상황 -> 1x2, 2x2, 2x1을 놓을 수 있으나 2x1 2개 놓는 경우는 1개 놓는 상황과 중복됨
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2] * 2) % 10007;
        }

        System.out.print(D[n]);
    }
}
