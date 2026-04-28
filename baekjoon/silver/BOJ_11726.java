package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] D = new int[n+1];
        D[1] = 1;
        if (n >= 2) D[2] = 2;

        // D[n-1]: 2x1이 남은 상황, 세로 블럭을 넣는 경우만 있다.
        // D[n-2]: 2x2가 남은 상황, 세로/가로 블럭을 2개 배치하는 경우가 있으나 세로 블럭을 2개 놓는 경우는 D[n-1]에서 다루므로 중복을 제거한다.
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        System.out.print(D[n]);
    }
}
