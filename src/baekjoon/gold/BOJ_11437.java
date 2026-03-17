package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11437 {
    static ArrayList<Integer>[] graph;
    static int[][] p;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 그래프 생성
        for (int i = 1; i <= n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // dfs로 노드의 부모와 깊이 탐색
        p = new int[n+1][2]; // 0: 부모 노드, 1: 깊이
        visited = new boolean[n+1];
        dfs(1, 0);

        // LCA 탐색
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int depthA = p[a][1];
            int depthB = p[b][1];
            int diff = depthA - depthB;

            // 노드 높이 맞추기
            while (diff != 0) {
                if (diff < 0) { // b가 더 깊은 경우
                    b = p[b][0];
                    depthB--;
                } else {
                    a = p[a][0];
                    depthA--;
                }
                diff = depthA - depthB;
            }

            // 하나씩 비교하며 공통 조상 찾기
            while (true) {
                if (a == b) {
                    sb.append(a).append("\n");
                    break;
                }
                a = p[a][0];
                b = p[b][0];
            }
        }
        br.close();

        System.out.print(sb);
    }

    static void dfs(int node, int depth) {
        if (visited[node]) return;
        visited[node] = true;

        for (int i : graph[node]) {
            if (visited[i] == false) {
                p[i][0] = node;
                p[i][1] = depth+1;
                dfs(i, depth+1);
            }
        }
    }
}
