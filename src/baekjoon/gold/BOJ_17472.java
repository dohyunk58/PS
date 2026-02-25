package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17472 {
    static int[][] graph;
    static boolean[][] visited;
    static int islandNum;
    static int n;
    static int m;

    // 상하좌우
    static int[] directionRow = {-1, 1, 0, 0};
    static int[] directionColumn = {0, 0, -1, 1};

    static ArrayList<ArrayList<int[]>> islands;
    static ArrayList<int[]> island;

    // MST를 위한 대표 노드
    static int[] parent;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 연결 요소 찾기
        islandNum = 1;
        islands = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    islandNum++;
                    islands.add(island);
                }
            }
        }

        // 섬 간 edge 찾기
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (ArrayList<int[]> i : islands) {
            for (int[] p : i) {
                int row = p[0];
                int column = p[1];
                int startIsland = graph[row][column];

                // 네 방향 중 한 방향으로 탐색
                for (int k = 0; k < 4; k++) {
                    int nextRow = row + directionRow[k];
                    int nextColumn = column + directionColumn[k];
                    int length = 0;

                    // 한 방향
                    while (nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < m) {
                        // 같은 섬을 만나면 중지
                        if (graph[nextRow][nextColumn] == startIsland) break;

                        // 다른 섬을 만나면
                        else if (graph[nextRow][nextColumn] != 0) {
                            if (length >= 2) pq.add(new Edge(startIsland, graph[nextRow][nextColumn], length)); // 길이가 2 이상일때 저장
                            break; // 더 전진하지 못하므로 다른 방향으로 탐색
                        }

                        // 바다면 더 탐색
                        else {
                            length++;
                        }

                        // 고른 방향으로 좌표 수정
                        nextRow += directionRow[k];
                        nextColumn += directionColumn[k];
                    }
                }
            }
        }

        // n-1개의 edge weight를 최소로 구하도록 MST를 사용하기
        parent = new int[islandNum];
        for (int i = 1; i < islandNum; i++) {
            parent[i] = i;
        }

        // weight가 낮은 edge부터 연결 시도
        int edgeCnt = 0;
        int weightSum = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            int start = now.start;
            int end = now.end;
            if (find(start) == find(end)) continue; // 같은 곳으로 연결되는 edge는 사이클을 형성하므로 넘김

            // 사이클이 없으면 연결
            union(start, end);
            // edge 비용 추가
            weightSum += now.weight;
            edgeCnt++;
            if (edgeCnt >= islandNum-2) break;
        }

        // 모든 섬을 연결하는 것이 불가능한 경우
        if (edgeCnt < islandNum-2) System.out.print(-1);
        else System.out.print(weightSum);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        island = new ArrayList<>();

        int[] start = new int[]{i, j};
        queue.add(start);
        island.add(start);

        visited[i][j] = true;
        graph[i][j] = islandNum;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int column = now[1];

            // 상하좌우 탐색
            for (int k = 0; k < 4; k++) {
                int nextRow = row + directionRow[k];
                int nextColumn = column + directionColumn[k];

                // 범위 밖이면 건너뜀
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= m) continue;

                // 방문했거나 바다면 건너뜀
                if (visited[nextRow][nextColumn] || graph[nextRow][nextColumn] == 0) continue;

                // 육지 방문 처리
                visited[nextRow][nextColumn] = true;
                graph[nextRow][nextColumn] = islandNum;
                int[] next = {nextRow, nextColumn};
                queue.add(next);
                island.add(next);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int find(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
