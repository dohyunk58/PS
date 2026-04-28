package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1219 {
    static final long MIN = Long.MIN_VALUE / 2;
    static final long MAX = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 간선 추가
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }

        // 도시 도착 보상 입력
        int[] arrivalProfit = new int[v];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < v; i++) {
            arrivalProfit[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 벨만포드 알고리즘
        long[] result = new long[v+1]; // 도시별 최대 순이익 (최소 비용, 최대 이익)
        for (int i = 0; i <= v; i++) { // 최소 순이익으로 업데이트
            result[i] = MIN;
        }
        result[startNode] = arrivalProfit[startNode];

        // 모든 간선 확인
        for (int i = 0; i < v + 100; i++) {
            for (int j = 0; j < e; j++) {
                Edge edge = edges[j];

                // 탐색된 지점인지 확인
                if (result[edge.start] == MIN) continue;

                // 출발점이 양수 사이클에 영향을 받은 지점이면 도착점도 양수 사이클 영향을 받음
                if (result[edge.start] == MAX) result[edge.end] = MAX;

                // 더 큰 순이익(현재 도착지 순이익 < 출발지 순이익 - 이동비 + 도착수익)이면 갱신
                if (result[edge.end] < result[edge.start] - edge.weight + arrivalProfit[edge.end]) {
                    result[edge.end] = result[edge.start] - edge.weight + arrivalProfit[edge.end];

                    // 모든 노드만큼 순회 후 값 변화 시 양수 사이클
                    if (i >= v-1) result[edge.end] = MAX;
                }
            }
        }

        if (result[endNode] == MIN) sb.append("gg");
        else if (result[endNode] == MAX) sb.append("Gee"); // 도착 지점이 양수 사이클에 영향을 받는 노드에서 접근 가능한 경우
        else sb.append(result[endNode]);

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
