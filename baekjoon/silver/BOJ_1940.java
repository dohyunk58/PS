package baekjoon.silver;

/*
오름차순으로 정렬된 배열에서 시작과 끝을 가리키는 인덱스를 선언하고
1. 앞 + 뒤 < m 이라면 앞 인덱스를 오른쪽으로 옮겨서 값을 키운다.
2. 앞 + 뒤 > m 이라면 뒤 인덱스를 왼쪽으로 옮겨서 값을 줄인다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1940 {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i]; // 비교 대상 (손에 쥔 카드)
            int j = i - 1;

            // 왼쪽에 target보다 큰 요소가 있으면 그 요소를 오른쪽으로 한 칸 이동시킴
            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j]; // 값 이동
                j--; // 인덱스를 왼쪽으로 한 칸 더 이동
            }

            // 왼쪽(j)에 더이상 target보다 큰 요소가 없으면(혹은 j가 -1이면) 그 위치(j+1)에 target을 삽입
            arr[j + 1] = target;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        insertionSort(arr); // 정렬

        int i = 0, j = n-1; // 배열의 앞과 뒤
        int count = 0;
        do {
            if(arr[i] + arr[j] < m) {
                i++;
            } else if(arr[i] + arr[j] > m) {
                j--;
            } else {
                count++;
                i++;
            }
        } while(i < j);

        System.out.print(count);
    }
}
