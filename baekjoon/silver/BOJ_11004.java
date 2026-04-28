package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        QuickSort.sort(numbers);
        System.out.println(numbers[k-1]);
    }

    static class QuickSort {
        public static void sort(int[] arr) {
            pivotSort(arr, 0, arr.length - 1);
        }

        private static void pivotSort(int[] arr, int start, int end) {
            if(start >= end) {
                return;
            }

            // pivot을 기준으로 왼쪽 오른쪽으로 나누고 정해진 pivot을 반환함
            int pivotIndex = partition(arr, start, end);

            // pivot 기준 왼쪽과 오른쪽을 다시 재귀 호출
            pivotSort(arr, start, pivotIndex - 1);
            pivotSort(arr, pivotIndex + 1, end);
        }

        private static int partition(int[] arr, int start, int end) {
            int mid = (start + end) / 2;
            swap(arr, start, mid); // 중앙값을 맨 앞으로 보내서 pivot으로 사용

            int pivot = arr[start];
            int i = start + 1;
            int j = end;

            while (i <= j) {
                while (i <= end && arr[i] < pivot) i++;
                while (j > start && arr[j] > pivot) j--;

                if (i <= j) {
                    swap(arr, i++, j--);
                }
            }

            // pivot을 제자리로 보냄 (j = pivot보다 작은 값중 가장 오른쪽 값)
            swap(arr, start, j);
            return j;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
