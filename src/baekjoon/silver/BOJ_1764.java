package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            names.add(br.readLine());
        }

        ArrayList<String> answer = new ArrayList<>();
        // 보도 못한 사람
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (names.contains(name)) {
                answer.add(name);
            } // else로 put(name, 1)해야 하지만 교집합을 찾아야 하니 생략했음
        }

        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (String name : answer) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
