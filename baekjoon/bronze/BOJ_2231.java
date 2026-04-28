package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
M = N + 각 자리수의 합
N = M - 각 자리수의 합
그런데 N의 최대값은 1,000,000 이므로 각 자리수의 최대값은 9*6 - 54밖에 안된다
따라서 각 자리수의 합만큼 M을 빼어 그 숫자가 M의 생성자인지 확인한다.
 */

public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int lengthOfM = (int)Math.log10(m) + 1;
        int sumOfDigit = 9 * lengthOfM; // m의 자리수 만큼 각 자리의 최대수로 절해짐
        boolean flag = false;

        for(int i = sumOfDigit; i >= 0; i--) {
            String n = Integer.toString(m - i);

            int sum = Integer.parseInt(n);
            // n이 m의 생성자인지 확인
            for(int j = 0; j < n.length(); j++) {
                sum += (n.charAt(j) - '0');
                if(sum > m) break;
            }
            if(sum == m) {
                System.out.println(n);
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println(0);
        }
    }
}
