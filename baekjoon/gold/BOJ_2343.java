package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] durations = new int[n];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            durations[i] = Integer.parseInt(st.nextToken());
            sum += durations[i];
            max = Math.max(max, durations[i]);
        }

        int low = max; // 최소 블루레이 크기(가장 큰 영상 하나)
        int high = sum; // 최대 블루레이 크기
        int result = sum;

        while (low <= high) {
            int mid = (low + high) / 2; // 블루레이 크기
            int bCnt = 1; // 블루레이 개수
            int bTempSum = 0; // 한 블루레이의 용량 상태

            for (int i = 0; i < n; i++) {
                if (bTempSum + durations[i] <= mid) { // 이번 영상을 블루레이 안에 넣을 수 있을 때
                    bTempSum += durations[i];
                } else {
                    bTempSum = durations[i];
                    bCnt++;
                }
            }

            if (bCnt <= m) { // 블루레이 개수가 목표 이하일때, 크기를 낮춰볼 수 있음
                high = mid - 1;
                result = Math.min(result, mid);
            } else {
                low = mid + 1;
            }
        }

        System.out.print(result);
    }
}
