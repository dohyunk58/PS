package baekjoon.gold;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1253 {
    static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > target) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        insertionSort(arr);

        int count = 0;
        for(int i = 0; i < n; i++) {
            int target = arr[i]; // 찾으려는 수
            int front = 0, end = n-1;
            while(front < end) {
                int sum = arr[front] + arr[end];
                if(sum == target) {
                    // 합이 자기 자신을 포함하지 못하도록 예외처리
                    if(front == i) {
                        front++;
                    } else if(end == i) {
                        end--;
                    } else {
                        count++;
                        break;
                    }
                } else if(sum < target) {
                    front++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
