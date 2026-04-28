package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new int[n+1];
        for (int i = 0; i <= n; i++) {
            set[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            boolean isFind = Integer.parseInt(st.nextToken()) == 1; // 0이면 union, 1이면 find
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // find
            if (isFind) {
                if (find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            } else { // union
                // union(a,b): b 그룹과 a 그룹이 모두 대표 노드 하나를 갖는다
                set[find(b)] = find(a);
            }
        }

        System.out.print(sb);
    }

    // 부모 노드 찾기
    static int find(int node) {
        // node가 부모노드 (index와 value가 같음)
        int masterIndex = node;

        // node가 자식 노드
        if (set[node] != node) {
            masterIndex = find(set[node]); // value를 index로 부모노드 탐색
            set[node] = masterIndex; // 최종 부모노드의 index를 value로 저장
        }

        return masterIndex;
    }
}
