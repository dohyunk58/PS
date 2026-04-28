package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;

        for (int i = 0; i < 3; i++) {
            try {
                // 네 번째 값 = i 번째 숫자 + (3-i)
                n = Integer.parseInt(br.readLine()) + (3-i);
            } catch (NumberFormatException e) {
                continue;
            }
        }

        if (n % 3 == 0 && n % 5 == 0) {
            System.out.print("FizzBuzz");
        } else if (n % 3 == 0) {
            System.out.print("Fizz");
        } else if (n % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(n);
        }
    }
}
