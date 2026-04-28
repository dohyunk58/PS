package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int[] times = new int[100_001];;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.print(0);
            return;
        }

        bfs(n, k);
    }

    public static void bfs(int node, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        times[node] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            int[] nextPositions = {now - 1, now + 1, now * 2};

            for (int next : nextPositions) {
                if (next == target) {
                    System.out.print(times[now]);
                    return;
                }

                // 범위 내에 있고 아직 방문하지 않은 경우
                if (next >= 0 && next <= 100_000 && times[next] == 0) {
                    times[next] = times[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
