package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1); // 없으면 기본값 0 + 1, 있으면 + 1
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }

        System.out.print(sb);
    }
}
