package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_9252 {
    static char[] n;
    static char[] m;
    static long[][] dp;
    static ArrayList<Character> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine().toCharArray();
        m = br.readLine().toCharArray();

        dp = new long[n.length+1][m.length+1];
        result = new ArrayList<>();

        // 두 문자열이 같으면 해당 문자를 사용(+1), 다른 경우 두 문자열중 큰 공통 문자열을 가져옴
        for (int i = 1; i <= n.length; i++) {
            for (int j = 1; j <= m.length; j++) {
                if (n[i-1] == m[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        long lcsLength = dp[n.length][m.length];
        sb.append(lcsLength).append("\n");

        if (lcsLength > 0) {
            find(n.length, m.length);
            for (int i = result.size() - 1; i >= 0; i--) {
                sb.append(result.get(i));
            }
        }

        System.out.print(sb);
    }
    public static void find(int a, int b) {
        if (a == 0 || b == 0) return;
        if (n[a-1] == m[b-1]) { // 둘이 같은 경우 결과에 적고 왼쪽 위(둘다 같은)로 이동
            result.add(n[a-1]);
            find(a-1, b-1);
        } else { // 둘이 다른 경우 큰 수로 이동
            if (dp[a-1][b] > dp[a][b-1]) {
                find(a-1, b);
            } else {
                find(a, b-1);
            }
        }
    }
}
