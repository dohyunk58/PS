package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2251 {
    static boolean[][] visited; // a, b의 양을 index로 사용

    static int maxA;
    static int maxB;
    static int maxC;

    static boolean[] answer;
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        answer[maxC] = true; // 초기값은 계산하지 않으므로 정답에 추가
        bfs(0, 0);

        // 정답 출력
        for (int i = 0; i <= 200; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);

    }

    static void bfs(int a, int b) {
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(new Node(a, b));
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // 6가지 붓기 작업 시도
            // sender, receiver 배열을 사용해 a,b,c 구분
            for (int i = 0; i < 6; i++) {
                // 대상 한계 계산
                int receiverLimit = 0;
                if (receiver[i] == 0) receiverLimit = maxA;
                else if (receiver[i] == 1) receiverLimit = maxB;
                else receiverLimit = maxC;

                // 용량 한계와 줄 수 있는 용량 중 작은 값으로 줄 용량 계산
                int[] next = {curr.a, curr.b, curr.c};
                int pour = Math.min(next[sender[i]], receiverLimit - next[receiver[i]]);

                // 물 옮기기
                next[sender[i]] -= pour;
                next[receiver[i]] += pour;

                // 방문하지 않은 새로운 상태라면 큐에 저장해 해당 상태를 더 탐색
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new Node(next[0], next[1]));

                    // A가 비어있을 때 C의 값을 저장
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class Node {
        public int a;
        public int b;
        public int c;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
            this.c = maxC - a - b;
        }
    }
}
