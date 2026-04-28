package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                String input = st.nextToken();
                if (j < i+1) continue; // 1행에서 1-1,1-2,1-3 확인했으므로 2행은 2-3부터 확인 -> i번째 행은 i+1열부터 확인

                int num = Integer.parseInt(input);
                if (num == 1) union(i, j);
            }
        }

        boolean isSame = true;
        st = new StringTokenizer(br.readLine());
        int parentNum = find(Integer.parseInt(st.nextToken()));
        for (int i = 2; i <= m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (find(num) != parentNum) {
                isSame = false;
                break;
            }
        }
        if(isSame) System.out.print("YES");
        else System.out.print("NO");
    }

    static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) parent[b] = a;
    }

    static int find(int node) {
        if (node == parent[node]) return node;
        else return parent[node] = find(parent[node]);
    }
}
