package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드판 입력
        String b = br.readLine();
        br.close();

        // 자바 String replace() 메서드를 사용하는 로직
        b = b.replace("XXXX", "AAAA");
        b = b.replace("XX", "BB");

        if (b.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(b);
        }

        // 개수를 수동으로 세는 로직
        /*
        char[] answer = new char[b.length()];

        // 문자열을 순회하며 개수를 세고 4 이상일 때 AAAA 배치, 2만 남은 경우 BB 배치
        int cnt = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == 'X') {
                cnt++;
                // 4개째 빈 곳인 경우 AAAA 배치
                if (cnt == 4) {
                    for (int j = 0; j < 4; j++) {
                        answer[i-j] = 'A';
                    }
                    cnt = 0;
                }
            } else { // .일떄
                if (cnt % 2 != 0) { // X가 홀수 개인 상로 . -> -1
                    System.out.print(-1);
                    return;
                } else if (cnt == 2) { // XX. -> BB.
                    answer[i] = '.';
                    for (int j = 1; j <= 2; j++) {
                        answer[i - j] = 'B';
                    }
                    cnt = 0;
                } else answer[i] = '.'; // .
            }
        }
        // X로 끝났을때
        if (cnt % 2 != 0) { // 홀수
            System.out.print(-1);
            return;
        } else if (cnt == 2) { // XX -> BB
            for (int j = 0; j < 2; j++) {
                answer[b.length()-1 - j] = 'B';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            sb.append(answer[i]);
        }
        System.out.print(sb);
         */
    }
}
