package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] meetings =  new int[n][2]; // {시작시간, 종료시간}

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시각이 빠른 순서대로 정렬하기, 종료 시각이 같은 경우 시작 시각이 빠른 것을 선택
        // 시작=종료가 있을 때 둘 다 선택되기 위함
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // 겹치지 않는 회의가 나올때 마지막 회의 종료시간을 설정하고 카운트 증가
        int cnt = 0; int lastEnd = -1;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEnd) {
                lastEnd = meetings[i][1];
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
