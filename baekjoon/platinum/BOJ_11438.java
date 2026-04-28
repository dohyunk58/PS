package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11438 {
    static ArrayList<Integer>[] graph;
    static int[] d;
    static int[][] p;
    static boolean[] visited;
    static int maxK;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 데이터 입력
        for (int i = 1; i <= n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        maxK = 0;
        for (int i = 1; i <= n; i <<= 1) { // 2^k <= n을 만족하는 k 찾기
            maxK++;
        }

        p = new int[maxK+1][n+1];
        d = new int[n+1];

        // 각 노드 깊이 탐색
        visited = new boolean[n+1];
        dfs(1, 0);

        // 2^k번째 부모까지 탐색
        for (int k = 1; k <= maxK; k++) {
            for (int i = 1; i <= n; i++) {
                p[k][i] = p[k-1][p[k-1][i]];
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findLca(a, b)).append("\n");
        }
        br.close();

        System.out.print(sb);
    }

    static void dfs(int node, int depth) {
        if (visited[node]) return;
        visited[node] = true;

        for (int i : graph[node]) {
            if (!visited[i]) {
                d[i] = depth + 1;
                p[0][i] = node;
                dfs(i, depth + 1);
            }
        }
    }

    static int findLca(int a, int b) {
        // 깊이 맞추기
        if (d[a] > d[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 깊이 차이가 20난다면 2^4(16), 2^2(4)로 b 위치를 올린다.
        for (int k = maxK; k >= 0; k--) {
            if ((1 << k) <= d[b]-d[a]) b = p[k][b]; // 2^k <= 깊이 차이
        }

        // 동일 조상 찾기, 동일하기 바로 직전 노드까지 올리기
        for (int k = maxK; k >= 0; k--) {
            if (p[k][a] != p[k][b]) {
                a = p[k][a];
                b = p[k][b];
            }
        }

        int lca = a;
        if (a != b) {
            lca = p[0][lca];
        }
        return lca;
    }
}
