package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int low = 1; // 최소 거리 1
        int high = houses[n-1] - houses[0]; // 최대 거리
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int routerCnt = 1; // 0번에는 기본적으로 설치가 되어 있음
            int lastRouter = houses[0];

            for (int i = 1; i < n; i++) {
                // 이전 공유기와 거리가 mid 이상인 경우 공유기 설치
                if (houses[i] - lastRouter >= mid) {
                    routerCnt++;
                    lastRouter = houses[i];
                }
            }

            if (routerCnt >= c) { // 라우터 개수가 목표치 이상인 경우 거리를 늘려보기 (거리 최대화)
                low = mid + 1;
                result = Math.max(result, mid);
            } else { // 라우터 개수가 목표보다 적은 경우 거리를 줄여보기
                high = mid - 1;
            }
        }

        System.out.print(result);
    }
}
