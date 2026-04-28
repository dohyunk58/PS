package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph  = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 그래프 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        visited = new int[n+1];
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }

        // bfs하며 visited에 거리를 저장
        bfs(x);
        ArrayList<Integer> matchNodes = new ArrayList<>();

        // k의 길이를 갖는 노드를 저장
        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) {
                matchNodes.add(i);
            }
        }
        if (matchNodes.isEmpty()) {
            System.out.print("-1");
        } else {
            Collections.sort(matchNodes);
            for (int i : matchNodes) System.out.println(i);
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
