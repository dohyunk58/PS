package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        for(int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        InsertionSort.insertionSort(times);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += times[i] * (n-i);
        }

        System.out.println(sum);
    }

    static class InsertionSort {
        public static void insertionSort(int[] arr) {
            for(int i = 1; i < arr.length; i++) {
                int index = i;

                // 정렬된 부분(i 왼쪽)을 탐색
                int j;
                for(j = 0; j < i; j++) {
                    if(arr[j] > arr[index]) {
                        shiftRight(arr, j, index);
                        break;
                    }
                }
            }
        }

        private static void shiftRight(int[] arr, int start, int end) {
            int lastNumber = arr[end];
            for(int i = end; i > start; i--) {
                arr[i] = arr[i-1];
            }
            arr[start] = lastNumber;
        }
    }
}
