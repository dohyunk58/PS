package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n+1];
        int[] leftSum = new int[n+1]; // leftSum[i]: 왼쪽에서 0부터 i까지의 최대합 (i로 끝나는 최대값)
        int[] rightSum = new int[n+1]; // rightSum[i]: 오른쪽에서 n부터 i까지의 최대합 (i로 시작하는 최대값)
        int result = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 수를 제거하지 않을 때의 최대값 구하기
        for (int i = 1; i <= n; i++) {
            // 지금까지의 값에서 지금 값을 더한 것과 여기서 새로 시작하는 것을 비교
            leftSum[i] = Math.max(numbers[i], leftSum[i-1] + numbers[i]);
            result = Math.max(result, leftSum[i]);
        }

        rightSum[n] = numbers[n];
        for (int i = n-1; i >= 1; i--) {
            // 현재 값 뒤에 나를 더할지 혹은 여기서부터 시작할지 비교
            rightSum[i] = Math.max(numbers[i], rightSum[i+1] + numbers[i]);
        }

        // i번째를 제거한다고 했을 때, i번째를 제거한 왼쪽의 최대합(leftSum[i-1]) + i번째를 제거한 오른쪽의 최대합(rightSum[i+1]) 구하기
        // rightSum[i+1]은 i+1번째 값으로 시작하는 최대값 구간을 갖고 있음
        for (int i = 1; i <= n-1; i++) {
            int removeSum = leftSum[i-1] + rightSum[i+1];
            result = Math.max(result, removeSum);
        }

        System.out.print(result);
    }
}
