package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        final int MAX = Integer.MAX_VALUE;

        Edge[] edges = new Edge[e+1];

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }
        br.close();

        long[] result = new long[v+1];
        for (int i = 1; i <= v; i++) {
            result[i] = MAX;
        }

        // 벨만포드 알고리즘으로 노드 간 최소 비용 게산
        result[1] = 0;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= e; j++) {
                Edge edge = edges[j];

                if (result[edge.start] != MAX
                        && result[edge.end] > result[edge.start] + edge.weight) {
                    result[edge.end] = result[edge.start] + edge.weight;
                }
            }
        }

        // 음수 사이클 찾기
        boolean minusCycle = false;
        for (int i = 1; i <= e; i++) {
            Edge edge = edges[i];

            // 한 번 더 돌렸을 때 더 작은 값을 갖게 되는 경우 -> 음수 사이클
            if (result[edge.start] != MAX
                    && result[edge.end] > result[edge.start] + edge.weight) {
                minusCycle = true;
                break;
            }
        }

        if (minusCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= v; i++) {
                if (result[i] == MAX) {
                    sb.append("-1\n");
                } else {
                    sb.append(result[i]).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
