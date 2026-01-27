package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[v+1];
        cnt = 0;
        dfs(1);

        System.out.print(cnt);
    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : graph[v]) {
            if(visited[i] == false) {
                cnt++;
                dfs(i);
            }
        }
    }
}
