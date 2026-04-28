package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 갖고 있는 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] lines = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long low = 1;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // 자르는 길이
            int lineSum = 0;

            for (int i = 0; i < k; i++) {
                lineSum += lines[i] / mid;
            }

            if (lineSum >= n) { // 자르는 기준을 길게 해도 되는 경우
                low = mid + 1;
                result = mid;
            } else { // 자르는 선을 짧게 해야 하는 경우
                high = mid - 1;
            }
        }

        System.out.print(result);
    }
}
