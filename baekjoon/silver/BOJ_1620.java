package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameDict = new HashMap<>(n+1); // value 탐색용
        String[] keyDict = new String[n+1]; // key 탐색용


        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameDict.put(name, i);
            keyDict[i] = name;
        }

        for (int i = 0; i < m; i++) {
            String command = br.readLine();
            try { // 숫자 입력 -> key 탐색
                int number = Integer.parseInt(command);
                sb.append(keyDict[number]).append("\n");
            } catch (Exception e) { // 문자입력 -> value 탐색
                sb.append(nameDict.get(command)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
