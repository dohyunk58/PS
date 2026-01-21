package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] indegree = new int[v+1];

        ArrayList<Integer>[] graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a b -> a 다음 b -> a->b 이므로 a에 b 추가, b in-degree +1
            graph[a].add(b);
            indegree[b]++;
        }

        // indegree가 0인 첫 노드를 찾기
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상정렬
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            sb.append(node).append(" ");
            for (int next : graph[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.print(sb);
    }
}