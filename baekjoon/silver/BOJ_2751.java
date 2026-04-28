package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751 {
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        temp = new int[n];

        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        MergeSort.mergeSort(numbers);

        for(int i = 0; i < n; i++) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class MergeSort {
        public static void mergeSort(int[] arr) {
            sort(arr, 0, arr.length-1);
        }

        public static void sort(int[] arr, int left, int right) {
            if(left == right) return;

            int mid = (left + right) / 2;

            // 왼쪽, 오른쪽 정렬 후 배열 합치기
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

        private static void merge(int[] arr, int left, int mid, int right) {
            // 왼쪽 오른쪽 배열의 시작점과 temp 배열 인덱스
            int l = left;
            int r = mid + 1;
            int idx = left;

            while(l <= mid && r <= right) {
                if(arr[l] < arr[r]) {
                    temp[idx++] = arr[l++];
                } else {
                    temp[idx++] = arr[r++];
                }
            }
            while(l <= mid) {
                temp[idx++] = arr[l++];
            }
            while(r <= right) {
                temp[idx++] = arr[r++];
            }

            for(int i = left; i <= right; i++) {
                arr[i] = temp[i];
            }
        }
    }
}
