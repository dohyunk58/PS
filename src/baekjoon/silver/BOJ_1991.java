package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int node = st.nextToken().toCharArray()[0] - 'A';
            int left = st.nextToken().toCharArray()[0] - 'A';
            if (left < 0 || left > n) left = -1;

            int right = st.nextToken().toCharArray()[0] - 'A';
            if (right < 0 || right > n) right = -1;

            tree[node] = new Node(left, right);
        }
        br.close();

        sb = new StringBuilder();
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.print(sb);
    }

    static class Node {
        int left;
        int right;

        public Node (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // 전위 순회: 루트 - 왼쪽 자식 - 오른쪽 자식
    static void preOrder(int now) {
        if (now == -1) return; // 노드가 없으면 돌아가기
        itoa(now);
        preOrder(tree[now].left);
        preOrder(tree[now].right);
    }

    // 중위 순회: 왼쪽 자식 - 루트 - 오른쪽 자식
    static void inOrder(int now) {
        if (now == -1) return;
        inOrder(tree[now].left);
        itoa(now);
        inOrder(tree[now].right);
    }

    // 후위 순회: 왼쪽 자식 - 오른쪽 자식 - 루트
    static void postOrder(int now) {
        if (now == -1) return;
        postOrder(tree[now].left);
        postOrder(tree[now].right);
        itoa(now);
    }

    // 0-25를 A-Z로 변환해 출력 버퍼에 저장
    static void itoa(int num) {
        sb.append((char)('A' + num));
    }
}
