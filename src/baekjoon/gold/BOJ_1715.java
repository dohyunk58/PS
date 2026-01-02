package baekjoon.gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long totalSum = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int c = a + b;
            totalSum += c;
            pq.add(c);
        }

        System.out.print(totalSum);
    }
}

