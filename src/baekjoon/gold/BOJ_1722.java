package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] cases = new long[n+1]; // 자릿수별 순열의 경우의 수
        cases[0] = 1; // 0!
        for (int i = 1; i <= n; i++) {
            cases[i] = cases[i-1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int subNum = Integer.parseInt(st.nextToken());

        ArrayList<Integer> number = new ArrayList<>();
        if (subNum == 1) {
            StringBuilder sb = new StringBuilder();
            long k = Long.parseLong(st.nextToken());

            for (int i = 1; i <= n; i++) number.add(i);

            for (int i = 1; i <= n; i++) { // 맨 앞자리부터
                int cnt = 1;
                for (int j = 0; j < number.size(); j++) {
                    if (cnt * cases[n-i] >= k) {
                        k = k - cases[n-i] * (cnt - 1);
                        sb.append(number.get(j)).append(" ");
                        number.remove(j);
                        break;
                    }
                    cnt++; // k 번째보다 작으면 더 늘리기
                }
            }
            System.out.print(sb);
        } else {
            long k = 1; // 순번

            for (int i = 1; i <= n; i++) number.add(i);

            for (int i = 1; i <= n; i++) {
                int target = Integer.parseInt(st.nextToken());

                // 몇 번째 수인지 찾고 2번째 이상인 경우 순번을 추가
                for (int j = 0; j < number.size(); j++) {
                    if (target == number.get(j)) {
                        // 현재 숫자보다 작은 숫자가 j개 있으므로 j * (남은자릿수)!를 건너뜀
                        k += (long) j * cases[n-i];
                        number.remove(j); // 사용한 수 제거
                        break;
                    }
                }
            }
            System.out.print(k);
        }
    }
}

