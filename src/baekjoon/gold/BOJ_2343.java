package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    한 블루레이 크기 범위: 최소 강의 중 max값 ~ 최대 모든 강의의 sum값

    마지막에 size가 아닌 left를 출력해야 하는 이유
    - 1~9까지 9개 강의를 3개에 넣는 경우, left 17, right 16이 마지막 루프
 */

public class BOJ_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 시간 입력
        int[] videos = new int[n];
        int timeSum = 0; int maxTime = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(st.nextToken());
            videos[i] = time;
            timeSum += time;
            if (maxTime < time) maxTime = time;
        }

        // 최소(가장 큰 비디오 시간)값부터 최대(모든 비디오 시간의 합)값 중에서 조건에 부합하는 크기를 찾기
        int size = 0;
        int left = maxTime; int right = timeSum;
        while (left <= right) {
            size = (left + right) / 2;
            int cnt = 1;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += videos[i];

                // 사이즈를 초과하면 블루레이에 담기
                if (sum > size) {
                    cnt++;
                    sum = videos[i];
                }
            }

            // 블루레이 개수에 따라서 index를 조정
            // 더 많은 블루레이가 필요하면 크기를 늘린다
            if (cnt > m) {
                left = size + 1;
            } else { // 블루레이 개수가 더 적거나 같으면 크기를 줄여본다
                right = size - 1;
            }
        }

        System.out.println(left);
    }
}
