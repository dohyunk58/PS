package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // weight 오름차순 정렬
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // edge 추가
        PriorityQueue<Edge> edges = new PriorityQueue<>(m);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 낮은 weight의 edge를 꺼내 사이클이 없으면 union
        int edgeCnt = 0;
        int weightSum = 0;
        while (edgeCnt < n-1) {
            Edge now = edges.poll();

            int start = now.start;
            int end = now.end;
            if (find(start) == find(end)) continue; // 같은 곳으로 연결되는 edge는 사이클을 형성하므로 넘김

            // 사이클이 없으면 연결
            union(start, end);
            // edge 비용 추가
            weightSum += now.weight;
            edgeCnt++;
        }

        System.out.print(weightSum);
    }

    static int find(int node) {
        if (node == parent[node]) return node;
        else return parent[node] = find(parent[node]);
    }

    static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) parent[b] = a;
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
}
