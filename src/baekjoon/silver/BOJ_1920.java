package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static int[] numbers;
    public static int findNumber;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        numbers =  new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            findNumber = Integer.parseInt(st.nextToken());
            binarySearch(0, n-1);
        }

        System.out.print(sb);
    }

    public static void binarySearch(int left, int right) {
        boolean isFound = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > findNumber) {
                right = mid - 1;
            } else if (numbers[mid] < findNumber) {
                left = mid + 1;
            } else {
                isFound = true;
                break;
            }
        }

        if (isFound) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }
}
