package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[n+1][l+1][r+1]; // n개 빌딩에서 왼쪽에서 l개, 오른쪽에서 r개 보일때 가능한 경우의 수

        // n-1개 일때의 값을 모두 알 때, n개의 경우는 추가된 하나를 배치하기
        /*
        1) 가장 작은 빌딩을 왼쪽에 배치하는 경우는 왼쪽에 보이는 빌딩 +1: n개일때 l개가 보이므로 n-1개일때에는 l-1개인 경우의 수 dp[n-1][l-1][r]의 값 가져오기
        2) 가장 작은 빌딩을 오른쪽에 배치하는 경우 오른쪽에 보이는 빌딩 +1: n개일때 r개가 보이므로 n-1개일떄 r-1개가 보이는 경우의 수 dp[n-1][l][r-1]의 값 가져오기
        3) 그 이외(n-2곳)에 배치하는 경우 보이지 않으므로 l과 r이 n-1개일때와 동일: dp[n-1][l][r] 그리고 이 경우는 n-2가지 경우가 있으므로 dp[n-1][l][r] * (n-2)
         */

        dp[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k] * (i-2)) % 1_000_000_007;
                }
            }
        }

        System.out.print(dp[n][l][r]);
    }
}
