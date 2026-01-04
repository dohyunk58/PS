package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10이 곱해질때 0이 추가되므로 10이 곱해지는 경우를 찾는다.
// 2x5의 개수를 세어야 하지만 2의 개수가 5보다 훨씬 많으므로 n까지의 5의 배수를 찾는다

public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            // 25와 같이 5를 2개 갖는 경우 2번 추가해야하므로 temp를 두고 5를 몇 개 가지고 있는지 센다
            int temp = i;
            while (temp % 5 == 0) {
                count++;
                temp /= 5;
            }
        }

        System.out.println(count);
    }
}
