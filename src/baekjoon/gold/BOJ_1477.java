package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Integer> services = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            services.add(Integer.parseInt(st.nextToken()));
        }
        services.add(0);
        services.add(l);

        Collections.sort(services);

        int low = 1; // 휴게소를 둘 수 있는 가장 짧은 거리
        int high = l-1; // 가장 긴 거리
        int result = l;

        while (low <= high) {
            int mid = (low + high) / 2; // 휴게소를 설치할 최대 거리 기준
            int serviceCnt = 0;
            int lastService = 0;

            // 이전 휴게소와 거리가 기준 이상인 경우 휴게소 설치
            for (int i = 1; i < services.size(); i++) {
                int dist = services.get(i) - services.get(i-1);
                serviceCnt += (dist - 1) / mid; // 끝점 중복 설치 방지
            }
            // (dist - 1) / mid: 나누어떨어질 때 끝점 중복을 막고, 나머지가 있을 때 올림 처리
            // 예: 거리/기준이 100/50 -> 1개(50), 100/30 -> 3개(30, 60, 90)

            // 목표로 하는 설치 수보다 최소 추가 설치 수가 적거나 같은 경우 목표에는 적합
            // 최적화를 위해 거리를 줄여본다
            if (serviceCnt <= m) {
                high = mid - 1;
                result = Math.min(result, mid);
            } else { // 너무 많은 휴게소가 필요하다면 간격 기준을 키워야 함
                low = mid + 1;
            }
        }

        System.out.print(result);
    }
}
