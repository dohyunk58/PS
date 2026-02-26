package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1414 {
    static int[] parent;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0; // 선의 총합

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            char[] lines = br.readLine().toCharArray();

            // a-z:1-26 A-Z:27-52
            for (int j = 0; j < n; j++) {
                int len = 0;

                if (lines[j] >= 'a' && lines[j] <= 'z') {
                    len=  lines[j] - 'a' + 1;
                } else if (lines[j] >= 'A' && lines[j] <= 'Z') {
                    len = lines[j] - 'A' + 27;
                }

                sum += len;
                if (i != j && len != 0) pq.add(new Edge(i, j, len));
            }
        }

        // MST로 n-1개의 최소 weight edge 합 구하기
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int edgeCnt = 0;
        int weightSum = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            // find로 사이클 확인
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                edgeCnt++;
                weightSum += now.weight;
            }
        }

        if (edgeCnt <= n-2) System.out.print(-1);
        else System.out.print(sum - weightSum); // 남은 선
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static int find(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public static void union(int a, int b) {
        a = parent[a];
        b = parent[b];

        if (a != b) {
            parent[b] = a;
        }
    }
}
