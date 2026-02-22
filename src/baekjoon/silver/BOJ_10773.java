package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_10773 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>(k);

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) stack.removeLast();
            else stack.addLast(num);
        }

        int result = 0;
        for (int n : stack) {
            result += n;
        }
        System.out.print(result);
    }
}
