package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        // 그래프 생성
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 간선 추가
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        br.close();

        // 인접 노드 정렬
        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();
        dfs(startNode);
        System.out.println(sb);

        visited = new boolean[n+1];

        sb = new StringBuilder();
        bfs(startNode);
        System.out.print(sb);
    }

    public static void dfs(int now) {
        if(visited[now]) {
            return;
        }
        visited[now] = true;
        sb.append(now).append(" ");
        for(int i : graph[now]) {
            dfs(i);
        }
    }

    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int neighbor : graph[current]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
