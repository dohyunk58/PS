package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 각 노드(인원)의 부모 노드
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 파티별 참여 인원 저장 배열
        ArrayList<Integer>[] parties = new ArrayList[m+1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new ArrayList<Integer>();
        }

        // 진실을 아는 사람을 하나의 그룹으로 묶기
        st = new StringTokenizer(br.readLine());
        int knownPeople = Integer.parseInt(st.nextToken());
        int knownGroupRoot = 0;
        if (knownPeople > 0) {
            knownGroupRoot = Integer.parseInt(st.nextToken());
            for (int i = 2; i <= knownPeople; i++) {
                int knownPerson = Integer.parseInt(st.nextToken());
                union(knownGroupRoot, find(knownPerson));
            }
        }

        // 같은 파티에 참석한 사람들을 하나의 그룹으로 묶기
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int participants = Integer.parseInt(st.nextToken());

            int firstParticipant = Integer.parseInt(st.nextToken());
            parties[i].add(firstParticipant);

            for (int j = 2; j <= participants; j++) {
                int participant = Integer.parseInt(st.nextToken());
                parties[i].add(participant);

                union(firstParticipant, participant);
            }
        }

        // 파티별 진실을 아는 사람이 있는지 확인
        int count = 0;
        for (int i = 1; i <= m; i++) {
            boolean canLie = true;
            // 저장된 파티 정보를 탐색하며 진실을 아는 집합의 사람이 있는지 확인
            for (int person : parties[i]) {
                if(find(person) == find(knownGroupRoot)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }
        System.out.println(count);
    }

    static void union(int a, int b) {
        a = find(a); b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int node) {
        if (parent[node] == node) return node;
        else {
            return parent[node] = find(parent[node]);
        }
    }
}
