package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.print(1);
            return;
        } else if (n == 2) {
            System.out.print(2);
            return;
        }

        int prev2 = 1; // 직전 두 번째 값
        int prev1 = 2; // 직전 값
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 10007;
            // 한 칸씩 뒤로 미루기
            prev2 = prev1;
            prev1 = current;
        }

        System.out.print(current);
    }
}
