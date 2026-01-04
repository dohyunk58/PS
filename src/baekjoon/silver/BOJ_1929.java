package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] numbers = new int[n+1];
        for (int i = 2; i <= n; i++) {
            numbers[i] = i;
        }

        // 2부터 n의 루트까지 배수인지 확인하며 제거
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (numbers[i] == 0) continue;

            // i만큼 증가하며 해당 숫자를 0으로 만들기
            for (int j = i*2; j <= n; j = j + i) {
                numbers[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (numbers[i] != 0) System.out.println(numbers[i]);
        }
    }
}