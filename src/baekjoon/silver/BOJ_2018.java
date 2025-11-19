package baekjoon.silver;

/*
다음 세 가지 경우로 나누어 포인터를 움직인다.
    1) 시작~끝까지의 합 < N: 끝 포인터++
    2) 시작~끝까지의 합 == N: 결과++, 끝 포인터++
    3) 시작~끝까지의 합 > N: 처음 포인터++
끝포인터가 N에 도달하면 프로그램을 종료한다.
 */

import java.io.*;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int front = 1, end = 1;
        long sum = 1; int count = 0;
        do {
            if(sum < n) {
                end++;
                sum += end;
            } else if(sum == n) {
                count++;
                end++; sum += end;
            } else if(sum > n) {
                sum -= front;
                front++;
            }
        } while(front <= n && end <= n);

        System.out.print(count);
    }
}
