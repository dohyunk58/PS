package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1; int end = k;// NxN에서 k번째 수는 k보다 크지는 않음
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int smallerCnt = findSmallerNumber(n, mid);
            if (smallerCnt < k) { // 중앙값보다 작은 수의 개수 < k
                start = mid + 1;
            } else { // 중앙값보다 작은 수의 개수 >= k
                end = mid - 1;
                answer = mid;
            }
        }

        System.out.print(answer);
    }

    public static int findSmallerNumber (int n, int x) {
        int smallerCnt = 0;
        for (int i = 1; i <= n; i++) {
            int quotient = x / i;

            if (quotient > n) {
                quotient = n;
            }

            smallerCnt += quotient;
        }
        return smallerCnt;
    }
}
