package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = 666;

        while (true) {
            if (Integer.toString(number).contains("666")) {
                cnt++;
            }
            if (cnt == n) break;

            number++;
        }

        System.out.println(number);
    }
}
