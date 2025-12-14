package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            char[] answer = br.readLine().toCharArray();

            int sum = 0;
            int stack = 0;
            for(int j = 0; j < answer.length; j++) {

                if(answer[j] == 'O') {
                    sum += stack + 1;
                    stack++;
                } else {
                    stack = 0;
                }
            }

            System.out.println(sum);
        }
    }
}
