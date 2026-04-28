package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        ArrayList<Node>[] cities = new ArrayList[v+1];
        ArrayList<Node>[] reverseCities = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) {
            cities[i] = new ArrayList<Node>();
            reverseCities[i] = new ArrayList<Node>();
        }

        int[] indegree = new int[v+1];

        // 도로 정보
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            // u v w, 도시 u-v 거리 w일때, u를 지나 v에 가므로 u가 v를 가리킨다
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cities[a].add(new Node(b, w));
            reverseCities[b].add(new Node(a, w));
            indegree[b]++;
        }

        // 한걸음, 로마 입력
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 시작 지점부터 위상 정렬
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startCity);

        int[] result = new int[v+1];
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (Node nextNode : cities[now]) {
                indegree[nextNode.target]--;
                // 다음 도시의 기존거리 vs 현재 도시의 거리 + 다음 도시까지 가는 거리
                result[nextNode.target] = Math.max(result[nextNode.target], result[now] + nextNode.weight);
                if (indegree[nextNode.target] == 0) {
                    queue.add(nextNode.target);
                }
            }
        }

        // 위상정렬 후 가장 긴 시간을 만들어낸 길을 찾기 위해 역방향 위상정렬
        queue = new ArrayDeque<>();
        queue.add(endCity);
        boolean[] visited = new boolean[v+1];
        int cnt = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node prevNode : reverseCities[now]) {
                // 현재 도시의 위상정렬 결과와 이전 도시의 위상정렬결과 + weight 를 비교 (같으면 해당 엣지가 최장)
                if (result[now] == (result[prevNode.target] + prevNode.weight)) {
                    cnt++;
                    if (!visited[prevNode.target]) {
                        visited[prevNode.target] = true;
                        queue.add(prevNode.target);
                    }
                }
            }
        }

        // 도착하는 시간
        System.out.println(result[endCity]);
        System.out.print(cnt);
    }

    static class Node {
        int target;
        int weight;
        public Node (int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
