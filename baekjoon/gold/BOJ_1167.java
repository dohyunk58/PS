package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1167 {
    public static ArrayList<Edge>[] tree;
    public static int[] distance;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        tree = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            tree[i] = new ArrayList<Edge>();
        }

        // 간선, 거리 입력
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (true) {
                int nextNum = Integer.parseInt(st.nextToken());
                if (nextNum == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                tree[nodeNum].add(new Edge(nextNum, value));
            }
        }

        distance = new int[v+1];
        visited = new boolean[v+1];
        bfs(1);

        // 가장 먼 노드부터 다시 탐색
        int maxIndex = 1;
        for (int i = 2; i <= v; i++) {
            if (distance[maxIndex] < distance[i]) {
                maxIndex = i;
            }
        }

        distance = new int[v+1];
        visited = new boolean[v+1];
        bfs(maxIndex);

        int maxDistance = 0;
        for (int d : distance) {
            if (maxDistance < d) {
                maxDistance = d;
            }
        }
        System.out.print(maxDistance);
    }

    public static class Edge {
        int target;
        int value;

        public Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }
    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge e : tree[now]) {
                int target = e.target;
                int value = e.value;
                if(!visited[target]) {
                    visited[target] = true;
                    queue.add(target);
                    distance[target] = distance[now] + value;
                }
            }
        }
    }
}
