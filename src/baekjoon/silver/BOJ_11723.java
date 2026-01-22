package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int oneToTwenty = 0; // 1번째부터 20번째 비트의 0, 1 여부로 판단하기

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int target;

            if (command.equals("add")) {
                target = Integer.parseInt(st.nextToken());
                oneToTwenty = oneToTwenty | (1 << (target-1)); // x번째 비트를 1로 만들기
            } else if (command.equals("remove")) {
                target = Integer.parseInt(st.nextToken());
                oneToTwenty = oneToTwenty & ~(1 << (target-1)); // x번째 비트를 0으로 만들기
            } else if (command.equals("check")) {
                target = Integer.parseInt(st.nextToken());
                if ((oneToTwenty & (1 << (target-1))) != 0) {
                    sb.append("1").append("\n");
                } else sb.append("0").append("\n");
            } else if (command.equals("toggle")) { // 비트 반전
                target = Integer.parseInt(st.nextToken());
                oneToTwenty ^= (1 << (target-1));
            } else if (command.equals("all")) {
                oneToTwenty = (1 << 20) - 1;
            } else { // empty
                oneToTwenty = 0;
            }
        }

        System.out.print(sb);
    }
}
