package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ_2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] s = new long[n+1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        // i-j 구간합이 k => s[j] - s[i-1] = k, s[i-1] = s[j] - k
        // j번째 누적합 s[j]일때, j 이전에 s[j] - k와 같은 값을 갖는 개수만큼 짝을 이룰 수 있다.
        Map<Long, Integer> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += map.getOrDefault((s[i] - k), 0); // s[j]-k 값을 갖는 구간합의 개수
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
        }

        System.out.print(result);
    }
}
