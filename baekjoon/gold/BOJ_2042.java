package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042 {
    static long[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // leaf node의 수가 n개 이상인 이진 트리 생성
        long h = 1;
        while (Math.pow(2, h) < n) {
            h++;
        }
        tree = new long[(int) Math.pow(2, h + 1)];

        int leafNodeStart = (int) Math.pow(2, h);

        // 데이터 입력
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            int index = i + leafNodeStart;
            tree[index] = num;
        }

        // 부모 노드에 자식 노드 합 저장
        for (int i = leafNodeStart - 1; i > 0; i--) {
            long lChild = tree[2 * i];
            long rChild = tree[2 * i + 1];

            tree[i] = lChild + rChild;
        }

        // 데이터 변경, 부분합 출력
        for (int i = 0; i < k + m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // b를 c로 변경
                int index = b + leafNodeStart - 1;
                change(index, c);
            } else { // b부터 c까지 합을 출력
                int start = b + leafNodeStart - 1;
                int end = (int)c + leafNodeStart - 1;
                print(start, end);
            }
        }

        System.out.print(sb);
    }

    static void change(int b, long c) {
        tree[b] = c;
        // 부모 노드 변경
        int index = b;
        while (index != 1) {
            index /= 2;
            long lChild = tree[2 * index];
            long rChild = tree[2 * index + 1];

            tree[index] = lChild + rChild;
        }
    }

    static void print(int start, int end) {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) sum += tree[start++]; // 오른쪽 자식일때
            if (end % 2 == 0) sum += tree[end--]; // 왼쪽 자식일때
            start /= 2;
            end /= 2;
        }
        sb.append(sum).append("\n");
    }
}
