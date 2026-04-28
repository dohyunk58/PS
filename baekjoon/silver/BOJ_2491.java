package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int upCnt = 1;
        int downCnt = 1;

        for (int i = 1; i < n; i++) {
            if (numbers[i] > numbers[i-1]) {
                upCnt++;
                downCnt = 1;
            } else if (numbers[i] < numbers[i-1]) {
                downCnt++;
                upCnt = 1;
            } else if (numbers[i] == numbers[i-1]) {
                upCnt++;
                downCnt++;
            }
            max = Math.max(max, Math.max(upCnt, downCnt));
        }

        System.out.print(max);
    }
}
