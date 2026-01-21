package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] indegree = new int[n+1];
        int[] requestTimes = new int[n+1];
        int[] totalTimes = new int[n+1];
        ArrayList<Integer>[] buildings = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            buildings[i] = new ArrayList<Integer>();
        }


        for (int i = 1; i <= n; i++) {
            // 각 건물 시간 입력
            st = new StringTokenizer(br.readLine());
            int requestTime = Integer.parseInt(st.nextToken());
            requestTimes[i] = requestTime;

            // 필수 요구 건물 번호 입력
            // B 건물 짓는데 A가 필요함 = A 노드가 B를 가리킴
            while (true) {
                int precondition = Integer.parseInt(st.nextToken());
                if (precondition == -1) break;

                buildings[precondition].add(i);
                indegree[i]++;
            }
        }

        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                totalTimes[i] = requestTimes[i]; // 선행 건축물이 없으면 최종 건축 시간 확정
            }
        }

        // totalTimes[next]는 여러 선행건축물 시간 중 가장 큰 시간을 저장
        // totlaTimes[now]는 고려할 선행 건축물이 없는(in degree 0) 건축물로, 건축 시간을 저장
        while (!queue.isEmpty()) {
            int now = queue.removeFirst();
            // 가리키는 다음 건물(이 건물이 필요했던 건물)을 꺼내 시간 추가
            for (int next : buildings[now]) {
                // 여러 선행건축물 시간 중 가장 큰 시간을 next에 저장
                totalTimes[next] = Math.max(totalTimes[next], totalTimes[now]);
                indegree[next]--;
                if (indegree[next] == 0) { // 최종 시간이 확정될 때 next의 건축 시간까지 더해 저장
                    queue.add(next);
                    totalTimes[next] += requestTimes[next];
                }
            }
        }

        for (int i = 1; i<= n; i++) {
            sb.append(totalTimes[i]).append("\n");
        }
        System.out.print(sb);
    }
}
