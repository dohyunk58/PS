package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        final int MAX = Integer.MAX_VALUE;

        ArrayList<Edge>[] graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }

        // 시작, 끝 지점
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        br.close();

        // 최소거리
        int[] length = new int[v+1]; // 시작 노드에서 특정 노드 간 거리
        for (int i = 0; i <= v; i++) {
            length[i] = MAX;
        }
        length[startNode] = 0;

        boolean[] visited = new boolean[v+1];
        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(startNode, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int now_target = now.target;
            if (visited[now_target]) continue; // 방문한 적 있는 노드 제외
            visited[now_target] = true;

            for (Edge next : graph[now_target]) {
                // next로 가는 간선이 최소 거리 -> 큐에 추가(이 길을 선택), 최소거리(length) 수정
                if (length[next.target] > length[now_target] + next.weight) {
                    length[next.target] = length[now_target] + next.weight;
                    queue.add(new Edge(next.target, length[next.target]));
                }
            }
        }

        System.out.print(length[endNode]);
    }

    static class Edge implements Comparable<Edge> {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 가중치 기준 오름차순 정렬
        }
    }
}
