package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    1. 1-4로 연결된 경우 그 간선을 1에서도, 4에서도 탐색 가능해야 하므로 양방향 간선처리해야함
    2. 5명의 연결이 3-4-1-2-0 같이 0부터 시작하지 않을 수 있으므로 모든 노드에 대해서 dfs해야함
    3. 각 노드마다 시작할 수 있도록 한 경로의 탐색이 끝날때마다 visited를 초기화해야함
 */

public class BOJ_13023 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            graph[a].add(b);
            graph[b].add(a);
        }

        result = 0;
        // 모든 노드에 대해서 dfs 수행
        for(int i = 0; i < n; i++) {
            dfs(i, 1);
            if(result == 1) break;
        }
        System.out.println(result);
    }

    public static void dfs(int num, int length) {
        if(visited[num] || result == 1) {
            return;
        }
        visited[num] = true;

        if(length == 5) {
            result = 1;
            return;
        }

        for(int i : graph[num]) {
            if(visited[i] == false){
                dfs(i, length+1);
            }
        }

        // 다른 경로에서 이 노들르 다시 쓸 수 있도록 visited false 처리
        visited[num] = false;
    }
}
