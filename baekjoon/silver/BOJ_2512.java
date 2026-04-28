package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] requests = new int[n];
        int sum = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            sum += requests[i];
            max = Math.max(max, requests[i]);
        }

        int m = Integer.parseInt(br.readLine());
        br.close();

        if (m >= sum) {
            System.out.print(max);
            return;
        }

        int low = 0;
        int high = max;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2; // 상한
            int tempSum = 0;

            for (int i = 0; i < n; i++) {
                if (requests[i] <= mid) { // 상한을 초과하지 않으면 해당 요구액을 수용
                    tempSum += requests[i];
                } else { // 상한을 초과하면 상한을 적용
                    tempSum += mid;
                }
            }

            if (tempSum <= m) { // 해당 상한의 결과로 인한 사용액이 예산 이내인 경우, 상한을 올린다.
                low = mid + 1;
                result = Math.max(result, mid);
            } else { // 예산을 초과하는 경우 상한을 줄인다.
                high = mid - 1;
            }
        }

        System.out.print(result);
    }
}
