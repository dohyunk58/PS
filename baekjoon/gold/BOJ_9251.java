package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] dp = new int[a.length+1][b.length+1]; // 문자열 a와 b가 i, j까지 있을 때의 최대 공통 부분 수열

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) { // 두 문자가 같은 경우 이전 문자까지의 최대 공통 부분 수열에 값을 더함
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else { // 다른 경우 위와 왼쪽의 LCS중 큰 값이 ij의 LCS가 됨
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[a.length][b.length]);
    }
}
