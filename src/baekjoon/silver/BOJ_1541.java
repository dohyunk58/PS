package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        // - 기호로 나누기
        String[] minusGroups = expression.split("-");

        int total = 0;

        for (int i = 0; i < minusGroups.length; i++) {
            // 그룹 합
            int sum = 0;
            // + 기호로 나눠 더하기
            String[] numbers = minusGroups[i].split("\\+");

            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }

            // 첫 번째 그룹은 더하고 나머지 빼기
            if (i == 0) {
                total += sum;
            } else {
                total -= sum;
            }
        }
        System.out.print(total);
    }
}
