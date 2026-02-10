package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final int STARTNODE = 1;

        int[][] graph = new int[v+1][v+1];

        // 각 노드 별 k개의 경로를 담기
        PriorityQueue<Integer>[] lengthQueue = new PriorityQueue[v+1];
        // 내림차순 설정
        for (int i = 0; i <= v; i++) {
            lengthQueue[i] = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        }

        // 간선 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start][end] = weight;
        }
        br.close();

        // 다익스트라
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(STARTNODE, 0));
        lengthQueue[STARTNODE].add(0);
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 연결된 인접노드 탐색
            for (int adjNode = 1; adjNode <= v; adjNode++) {
                if (graph[now.node][adjNode] != 0) {
                    // 찾은 경로가 k개 이하면 탐색하는 경로 그냥 추가
                    if (lengthQueue[adjNode].size() < k) {
                        lengthQueue[adjNode].add(now.weight + graph[now.node][adjNode]);
                        queue.add(new Node(adjNode, now.weight + graph[now.node][adjNode]));
                    } else if (lengthQueue[adjNode].peek() > now.weight + graph[now.node][adjNode]) { // 경로가 k개인 경우 들어있는 값보다 작으면 경로 추가
                        lengthQueue[adjNode].poll();
                        lengthQueue[adjNode].add(now.weight + graph[now.node][adjNode]);
                        queue.add(new Node(adjNode, now.weight + graph[now.node][adjNode]));
                    }
                }
            }
        }

        // k번째 경로 출력
        for (int i = 1; i <= v; i++) {
            if (lengthQueue[i].size() == k) {
                sb.append(lengthQueue[i].peek()).append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
