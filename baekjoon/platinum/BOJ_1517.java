package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1517 {
    static int[] temp;
    static long swap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        swap = 0;
        MergeSort.sort(numbers);

        System.out.println(swap);
    }

    static class MergeSort {
        public static void sort(int[] numbers) {
            mergeSort(numbers, 0, numbers.length - 1);
        }

        private static void mergeSort(int[] numbers, int left, int right) {
            if(left == right) return;

            int mid = (left+right) / 2;
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid+1, right);

            merge(numbers, left, mid, right);
        }

        private static void merge(int[] numbers, int left, int mid, int right) {
            int l = left;
            int r = mid + 1;
            int idx = left;

            while (l <= mid && r <= right) {
                // 두 수가 같을 때에는 swap을 늘리지 않는 위쪽에서 처리함
                if (numbers[l] <= numbers[r]) {
                    temp[idx++] = numbers[l++];
                } else { // 오른쪽 배열의 숫자가 더 작을 때, 왼쪽 배열의 수만큼 움직여야 한다
                    swap += (mid - l + 1);
                    temp[idx++] = numbers[r++];
                }
            }
            while (l <= mid) {
                temp[idx++] = numbers[l++];
            }
            while (r <= right) {
                temp[idx++] = numbers[r++];
            }

            for(int i = left; i <= right; i++) {
                numbers[i] = temp[i];
            }
        }
    }
}
