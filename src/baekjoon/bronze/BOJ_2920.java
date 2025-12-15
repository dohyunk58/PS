package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[8];
        boolean descending = true;
        boolean ascending = true;
        for(int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());

            if(i > 1 && numbers[i-1] != numbers[i] + 1) { // 내림차순이 아닐때
                // 내림차순 플래그 제거
                descending = false;
            } else if(i > 1 && numbers[i-1] != numbers[i] - 1) { // 오름차순이 아닐때
                // 오름차순 플래그 제거
                ascending = false;
            }
        }

        if(ascending) {
            System.out.println("ascending");
        } else if(descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
