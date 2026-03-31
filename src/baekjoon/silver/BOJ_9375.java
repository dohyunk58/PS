package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>(); // k: 의상 종류, v: 의상 개수

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            // 의상종류 별로 개수 + 1(안 입기)를 경우의 수로 생각하고 각 종류별로 곱한다.
            int result = 1;
            for (int value : map.values()) {
                result *= (value + 1);
            }

            sb.append(result - 1).append("\n"); // 아무것도 입지 않는 경우의 수 제거
        }
        br.close();

        System.out.print(sb);
    }
}
