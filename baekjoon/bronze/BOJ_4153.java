package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4153 {
    static int maxIndex(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[max]) max = i;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int zeroCount = 0;

            // 배열 입력
            int[] arr = new int[3];
            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == 0) zeroCount++;
            }

            // 0 0 0인지 확인
            if(zeroCount == 3) {
                break;
            }

            // 가장 긴 변의 인덱스
            int maxIndex = maxIndex(arr);
            int shortSum = 0;
            for(int i = 0; i < 3; i++) {
                if(i == maxIndex) continue;
                shortSum += arr[i] * arr[i];
            }

            if(shortSum == arr[maxIndex] * arr[maxIndex]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
