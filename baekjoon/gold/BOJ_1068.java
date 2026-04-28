package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static ArrayList<Integer>[] graph;
    static int leafCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 부모-자식 단방향 그래프 인접 리스트
        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (p == -1) root = i;
            else graph[p].add(i);
        }

        // 노드 제거
        int removeNum = Integer.parseInt(br.readLine());

        // 루트 노드를 제거한다면 모든 노드가 제거되므로 leaf node 0개 처리
        if (removeNum == root) {
            System.out.print(0);
            return;
        }

        // removeNum을 자식으로 갖는 부모를 찾아 해당 연결 제거
        for (int i = 0; i < n; i++) {
            if (graph[i].contains(removeNum)) {
                graph[i].remove(Integer.valueOf(removeNum));
                break;
            }
        }

        // leaf node 탐색
        leafCount = 0;
        findLeaf(root);

        System.out.print(leafCount);
    }

    static void findLeaf(int node) {
        if (graph[node].isEmpty()) {
            leafCount++;
            return;
        }

        // 자식 탐색
        for (int c : graph[node]) {
            findLeaf(c);
        }
    }
}
