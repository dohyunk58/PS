package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11505 {
    static long[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // leaf node가 n개 이상인 segment tree 만들기
        // leaf node 수 찾기
        int leafCount = 1;
        while (leafCount < n) {
            leafCount *= 2;
        }
        tree = new long[leafCount * 2];
        for (int i = 0; i < leafCount*2; i++) {
            tree[i] = 1;
        }

        // 데이터 입력
        for (int i = 0; i < n; i++) {
            tree[leafCount+i] = Integer.parseInt(br.readLine());
        }

        // 부모 데이터 입력
        for (int i = leafCount - 1; i > 0; i--) {
            long leftChild = tree[i*2];
            long rightChild = tree[i*2 + 1];
            tree[i] = (leftChild * rightChild) % 1_000_000_007;
        }

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 수정
            if (a == 1) {
                b = leafCount + b - 1;
                change(b, c);
            } else { // 곱 출력
                b = leafCount + b - 1;
                c = leafCount + c - 1;
                print(b, c);
            }
        }

        System.out.print(sb);
    }

    static void change(int index, int num) {
        tree[index] = num;

        // 부모 값 변경
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % 1_000_000_007;
        }
    }

    static void print(int start, int end) {
        long mul = 1;

        while (start <= end) {
            if (start % 2 == 1) mul = (mul * tree[start++]) % 1_000_000_007;
            if (end % 2 == 0) mul = (mul * tree[end--]) % 1_000_000_007;
            start /= 2;
            end /= 2;
        }

        sb.append(mul).append("\n");
    }
}
