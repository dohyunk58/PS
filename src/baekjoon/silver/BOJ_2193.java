package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        br.close();

        long[][] D = new long[n+1][2]; // 자릿수 i인 이친수 중 끝자리가 각각 0, 1인 것의 개수
        D[1][0] = 0; D[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            // i번째 자리가 0이 되는 조건: i-1번째 자리가 0
            // 따라서 i-1자리 이친수 중 0으로 끝나는 이친수의 수만큼 i자리 1로 끝나는 이친수가 있을 수 이씅ㅁ
            D[i][1] = D[i-1][0];

            // i번째 자리가 0이 되는 경우는 i-1자리 이친수 모든 경우의 수와 같다 (0, 1다음에 모두 0이 올 수 있음)
            D[i][0] = D[i-1][0] + D[i-1][1];
        }

        System.out.print(D[n][0] + D[n][1]);
    }
}
