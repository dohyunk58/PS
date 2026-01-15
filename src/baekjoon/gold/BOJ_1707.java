package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] colors; // 초기값 0, 1 혹은 -1로 색을 칠함
    static boolean isBipartite;
    static final int COLOR_ONE = 1;
    static final int COLOR_TWO = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v+1];
            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            visited = new boolean[v+1];
            colors = new int[v+1];
            isBipartite = true;

            // 간선 입력
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int j = 1; j <= v; j++) {
                if (colors[j] == 0) { // 방문하지 않은 정점 발견 시 탐색
                    dfs(j, COLOR_ONE);
                }
                if (!isBipartite) break; // 이미 이분 그래프가 아님이 판정되면 종료
            }

            if (isBipartite) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    static void dfs(int startNode, int color) {
        colors[startNode] = color;

        for (int adjacent : graph[startNode]) {
            if (!isBipartite) return;

            // 시작 정점과 인접 정점의 색이 같으면 이분 그래프가 아님
            if (colors[startNode] == colors[adjacent]) {
                isBipartite = false;
                return;
            }

            // 아직 방문하지 않은 경우 반대 색을 칠한다.
            if (colors[adjacent] == 0) {
                dfs(adjacent, -1 * color);
            }
        }
    }
}
