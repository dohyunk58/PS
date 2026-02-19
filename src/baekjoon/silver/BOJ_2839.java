package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int five = 0;
        int three = 0;
        int remain = n;

        five = n / 5;
        remain %= 5;
        if (remain == 0) {
            System.out.print(five);
            return;
        }

        while (true) {
            if (remain % 3 == 0) {
                three = remain / 3;
                break;
            } else if (remain % 3 != 0) {
                if (five == 0) {
                    System.out.print(-1);
                    return;
                } else {
                    five--;
                    remain += 5;
                }
            }
        }

        System.out.print(three + five);
    }
}
