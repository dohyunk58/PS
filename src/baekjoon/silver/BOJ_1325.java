package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1325 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // a가 b를 신뢰한다 -> b를 통해 a에 접근할 수 있다
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        answer = new int[n+1];
        visited = new boolean[n+1];

        // 모든 노드에 대해 BFS
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            bfs(i);
        }

        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            maxCount = Math.max(maxCount, answer[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxCount) sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited[startNode] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        answer[startNode] = count;
    }
}
