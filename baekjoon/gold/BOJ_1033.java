package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1033 {
    static ArrayList<Node>[] arr;
    static long[] elements;
    static long lcm;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<Node>();
        elements = new long[n];
        visited = new boolean[n];
        lcm = 1;

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 비율 저장
            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));

            // 전체 최소공배수 구하기
            lcm *= (p * q / gcd(p, q));
        }

        // lcm을 0번에 할당하고 모든 노드를 탐색해 비율 계산
        elements[0] = lcm;
        dfs(0);

        long gcd = elements[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, elements[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(elements[i] / gcd + " ");
        }
        System.out.print(sb);
    }

    public static long gcd(long a, long b) {
        if (b > a) {
            long temp = b;
            b = a;
            a = temp;
        }

        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (Node i : arr[node]) {
            int next = i.b;
            if (!visited[next]) {
                // 현재 노드의 값이 elements[node]일 때, 연결된 다음 노드의 값은 elements[node] * q / p
                elements[next] = elements[node] * i.q / i.p;
                dfs(next);
            }
        }
    }
}

class Node {
    int b, p, q;
    public Node(int b, int p, int q) {
        this.b = b; this.p = p; this.q = q;
    }
}