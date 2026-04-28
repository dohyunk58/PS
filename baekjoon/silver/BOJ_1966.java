package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<Node>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                int p = Integer.parseInt(st.nextToken());
                pq.add(p);
                queue.add(new Node(j, p));
            }

            int count = 0; // 인쇄 횟수
            while (!queue.isEmpty()) {
                Node now = queue.poll();

                // 현재 중요도가 가장 높은지 확인
                if (now.value == pq.peek()) {
                    count++;
                    pq.poll();

                    if (now.index == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    // 중요도가 낮으면 큐의 뒤로 보냄
                    queue.add(now);
                }
            }
        }

        System.out.print(sb);
    }

    public static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
