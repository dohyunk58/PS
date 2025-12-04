package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력받은 문자열의 아스키코드값을 IntStream으로 바꾸고 각 요소에 -'0'한 값을 int형 배열로 저정함
        int[] arr = br.readLine().chars()
                .map(c -> c - '0')
                .toArray();

        SelectionSort.selectionSort(arr);

        for(int num : arr) {
            sb.append(num);
        }
        System.out.println(sb);
    }

    static class SelectionSort {
        public static void selectionSort(int[] arr) {
            selectionSort(arr, arr.length);
        }

        private static void selectionSort(int[] arr, int size) {
            for(int i = 0; i < size - 1; i++) {
                int maxIndex = i;

                // i번째부터 배열 끝까지 최소값 인덱스 찾기
                for(int j = i+1; j < size; j++) {
                    if(arr[j] > arr[maxIndex]) {
                        maxIndex = j;
                    }
                }

                // 최소값과 i번째 교환
                swap(arr, maxIndex, i);
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
