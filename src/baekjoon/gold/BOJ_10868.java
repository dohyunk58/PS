package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10868 {
    static StringBuilder sb;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int leafCount = 1;
        while (leafCount < n) {
            leafCount *= 2;
        }

        // segment tree 구현을 위해 leaf node가 n개 이상인(leafCount개) 배열 생성
        tree = new int[leafCount*2];
        for (int i = leafCount; i <= leafCount * 2 - 1; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        // 데이터 입력
        for (int i = 0; i < n; i++) {
            tree[leafCount+i] = Integer.parseInt(br.readLine());
        }

        // 부모 데이터 (두 자식 중 최솟값) 선택
        for (int i = leafCount-1; i >= 1; i--) {
            int leftChild = tree[i*2];
            int rightChild = tree[i*2 + 1];

            tree[i] = Math.min(leftChild, rightChild);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // leaf node가 존재하는 index로 매핑
            a = a + leafCount - 1;
            b = b + leafCount - 1;

            sb.append(findMin(a, b)).append("\n");
        }
        br.close();

        System.out.print(sb);
    }

    static int findMin(int start, int end) {
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            // 두 자식 중 오른쪽 자식만 확인하는 경우, 왼쪽 자식만 확인하는 경우 해당 자식만 min과 비교
            if (start % 2 == 1) min = Math.min(tree[start++], min);
            if (end % 2 == 0) min = Math.min(tree[end--], min);
            // 부모 탐색
            start /= 2;
            end /= 2;
        }

        return min;
    }
}
