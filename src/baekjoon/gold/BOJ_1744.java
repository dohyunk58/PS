package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 양수는 큰 수를 우선(Max Heap), 음수는 작은 수를 우선(Min Heap)
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int oneCount = 0;
        boolean hasZero = false;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) hasZero = true;
            else if (number == 1) oneCount++;
            else if (number > 1) positive.add(number);
            else negative.add(number);
        }

        int sum = 0;
        // 1의 개수만큼 더하기
        sum += oneCount;

        // 양수 큰 수 2개를 곱해 더하기
        while (positive.size() >= 2) {
            int a = positive.poll();
            int b = positive.poll();

            sum += a * b;
        }
        if (positive.size() == 1) sum += positive.poll(); // 1개 남은 경우 더하기

        // 음수 절대값 큰 수 2개를 곱해 더하기
        while (negative.size() >= 2) {
            int a = negative.poll();
            int b = negative.poll();

            sum += a * b;
        }
        // 음수가 1개 남고, 0이 없는 경우 더하기
        if (negative.size() == 1 && !hasZero) {
            sum += negative.poll();
        }

        System.out.print(sum);
    }
}
