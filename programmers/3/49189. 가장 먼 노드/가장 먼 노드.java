import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph; // 인접 리스트
    static int[] dist;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        // 그래프에 간선 추가
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dist = new int[n+1];
        visited = new boolean[n+1];
        find(1);
        
        // 거리 배열 확인
        int maxCnt = 0;
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (maxDist < dist[i]) {
                maxCnt = 1;
                maxDist = dist[i];
            } else if (maxDist == dist[i]) {
                maxCnt++;
            }
        }
        
        int answer = maxCnt;
        return answer;
    }
    
    static void find(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        dist[startNode] = 0;
        queue.offer(startNode);
        
        while (!queue.isEmpty()) {
            int now =  queue.poll();
            for (int i : graph[now]) {
                if (!visited[i]) {
                    queue.offer(i);
                    dist[i] = dist[now] + 1;
                    visited[i] = true;
                }
            }
        }
    }
}