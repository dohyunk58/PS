package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int t = n + m;

        int[][] D = new int[t+1][t+1];
        for (int i = 0; i <= t; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) D[i][j] = 1; // nC0 = nCn = 1
                else {
                    if (D[i-1][j] + D[i-1][j-1] > 1_000_000_000) D[i][j] = 1_000_000_001; // 오버플로우 방지
                    else D[i][j] = D[i-1][j] + D[i-1][j-1];
                }
            }
        }

        // k가 모든 경우의 수를 넘었는지 확인
        if (D[t][n] < k) System.out.print(-1);
        else {
            StringBuilder sb = new StringBuilder();
            // 한 자리씩, 해당 자리수가 a(or z)일때의 경우의 수와 k를 비교
            for (int i = 1; i <= t; i++) {
                // 특정 문자를 다 썼는지 우선 확인
                if (n == 0) {
                    sb.append("z");
                    m--;
                    continue;
                } else if (m == 0) {
                    sb.append("a");
                    n--;
                    continue;
                }

                // 해당 자리가 a라고 가정하고 경우의 수를 k와 비교
                if (D[n+m-1][n-1] >= k) {
                    sb.append("a");
                    n--;
                } else { // 경우의 수가 k보다 작으면 z를 사용하고 a인 경우의 경우의 수를 뺀다
                    sb.append("z");
                    k -= D[n+m-1][n-1];
                    m--;
                }
            }
            System.out.print(sb);
        }
    }
}
