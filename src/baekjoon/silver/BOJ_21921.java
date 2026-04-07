package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visitors = new int[n+1];
        int[] sums = new int[n+1];

        // 방문자수 입력
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 1; i <= n; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            if (visitors[i] > max) {
                max = visitors[i];
            }
            sums[i] = sums[i-1] + visitors[i];
        }

        // 1~k의 합부터 1개씩 옮겨가며 n까지 확인
        int maxSum = sums[k];
        int maxCnt = 1;
        for (int i = 1; i <= n - k; i++) {
            int nowSum = sums[k + i] - sums[i];
            // 이전 합보다 크다면 변경
            if (nowSum > maxSum) {
                maxSum = nowSum;
                maxCnt = 1;
            } else if (nowSum == maxSum) {
                maxCnt++;
            }
        }

        if (maxSum == 0) System.out.print("SAD");
        else {
            System.out.print(maxSum+"\n"+maxCnt);
        }
    }
}
