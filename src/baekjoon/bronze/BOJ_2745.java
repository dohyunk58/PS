package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        char[] input = st.nextToken().toCharArray(); // ['Z','Z']
        int b = Integer.parseInt(st.nextToken()); // 36

        int result = 0;
        int length = input.length;
        for (int i = 0; i < length; i++) {
            char c = input[i];
            int number = 0;
            if (c >= '0' && c <= '9') {
                number = c - '0';
            }
            else if (c >= 'A' && c <= 'Z') {
                number = c - 'A' + 10;
            }

            result += (int)Math.pow(b, length - i - 1) * number;
        }
        sb.append(result);
        System.out.println(sb.toString());
    }
}
