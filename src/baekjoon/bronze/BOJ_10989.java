package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N <= 10,000,000 이고 시간 제한이 5초 이므로 O(n) 시간복잡도의 정렬 알고리즘을 사용

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 메모리 8MB 문제: LinkedList로 기수 정렬 구현시 메모리 초과 발생함
        // 1-10_000 까지의 개수를 저장하는 배열을 사용해 개수만큼 순서대로 출력하기
        int[] count = new int[10001];

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= 10000; i++) {
            while(count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }
        System.out.print(sb);
    }
}