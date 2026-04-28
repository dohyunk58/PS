package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();
        // * 찾기
        int index = isbn.indexOf("*");

        char[] numbers = isbn.toCharArray();
        // 훼손된 숫자를 0부터 9까지 모두 대입
        for (int expectedNum = 0; expectedNum <= 9; expectedNum++) {
            int sum = 0;

            // 각 자리수 계산
            for (int i = 0; i < 13; i++) {
                int num;
                if (i == index) {
                    num = expectedNum;
                } else {
                    num = isbn.charAt(i) - '0';
                }

                // 홀수 짝수에 따라 sum에 값 추가 (0부터 시작하므로 2로 나누어떨어지면 홀수)
                if (i % 2 != 0) {
                    sum += num * 3;
                } else {
                    sum += num;
                }
            }

            // 10으로 나눠떨어지는지 확인
            if (sum % 10 == 0) {
                System.out.print(expectedNum);
                break;
            }
        }
    }
}
