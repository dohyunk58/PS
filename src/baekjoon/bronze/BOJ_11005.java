package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class BOJ_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long input = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        List<Character> result = new ArrayList<>();
        while(true) {
            long remainder = input % b;
            if(remainder >= 0 && remainder <= 9) {
                result.add((char)(remainder + '0'));
            }
            else { // A부터 Z까지
                result.add((char)(remainder - 10 + 'A'));
            }
            input = input / b;

            if (input <= 0) break;
        }

        // 나머지 역순으로 출력
        for(int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        System.out.println(sb);
    }
}
