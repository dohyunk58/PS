package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_9506 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == -1) break;

            // 약수 찾기
            ArrayList<Integer> factors = new ArrayList<>();

            for (int i = 1; i <= (int)Math.sqrt(num); i++) {
                if (num % i == 0) {
                    factors.add(i);
                    if (num / i != i) factors.add(num / i);
                }
            }

            Collections.sort(factors);

            // 약수의 합인지 확인
            int sum = 0;
            for (int factor : factors) {
                if (factor != num) sum += factor;
            }

            if (sum == num) {
                sb.append(num + " = ");
                for (int i = 0; i < factors.size() - 2; i++) {
                    sb.append(factors.get(i) + " + ");
                }
                sb.append(factors.get(factors.size()-2) + "\n");
            } else {
                sb.append(num + " is NOT perfect.\n");
            }
        }

        System.out.print(sb);
    }
}
