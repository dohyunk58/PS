package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        final int MAX = 10 * v + 1;

        int startNode = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프에 간선 삽입
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }
        br.close();

        int[] length = new int[v+1]; // 시작 노드에서 특정 노드 간 거리
        for (int i = 0; i <= v; i++) {
            length[i] = MAX;
        }
        length[startNode] = 0;

        boolean[] visited = new boolean[v+1];
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int now_target = now.target;
            if (visited[now_target]) continue; // 방문한 적 있는 노드 제외
            visited[now_target] = true;

            for (Node next : graph[now_target]) {
                // 이 간선이 최소 거리라면 교체 후 큐에 최소 거리인 이 노드를 추가
                if (length[next.target] > length[now_target] + next.weight) {
                    length[next.target] = length[now_target] + next.weight;
                    queue.add(new Node(next.target, length[next.target]));
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (length[i] != MAX) {
                sb.append(length[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int target;
        int weight;

        public Node (int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 가중치 기준 오름차순 정렬
        }
    }
}
