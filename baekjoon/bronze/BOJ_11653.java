package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        br.close();

        int divisor = 2;
        while (true) {
            if (n % divisor == 0) {
                sb.append(divisor).append("\n");
                n /= divisor;
            } else divisor++;

            if (n == 1) break;
        }

        System.out.print(sb);
    }
}
