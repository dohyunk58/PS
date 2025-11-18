package baekjoon.gold;

/*
1. (A+B)%C 는 ((A%C)+(B%C))%C와 동일하다
2. S[i] - S[j]는 i부터 j+1까지 구간의 합이고, (S[i]-S[j]) % M = 0이라면 해당 구간의 합이 M의 배수라는 뜻이다.
3. 2번의 식을 변경해서 S[i] % M = S[j] % M이라면 i부터 j+1 구간의 합이 M의 배수라는 뜻이다.
4. 따라서 입력받은 값들의 합 배열을 M의 나머지로 변경하고
    1) 그 값이 0인 것들의 개수 (첫 번째 항부터의 합이 M의 배수인 것)
    2) 값이 x인 것들 중 2개를 뽑는 경우의 수 (0포함) (두 인덱스 구간의 합이 M의 배수인 것)
    을 더하면 구간의 합이 M인 경우의 수를 모두 더할 수 있다
 */

import java.io.*;
import java.util.*;

public class BOJ_10986 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 값 입력
        int[] list = new int[n+1];  // n개의 숫자
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] remainderList = new int[n+1];
        long result = 0;
        int[] remainderCountList = new int[m];           // 0~m-1
        for(int i = 1; i <= n; i++) {
            // 합 배열 S[i] = S[i-1] + arr[i]
            // 합 배열 공식에 나머지 연산 S[i] % m = (S[i-1] + arr[i]) % m
            remainderList[i] = (remainderList[i-1] + list[i]) % m;
            if(remainderList[i] == 0) {                    // 나머지가 0 (1번 경우 - 첫 번째 항부터 합이 m의 배수)
                result++;
            }
            remainderCountList[remainderList[i]]++;           // 나머지가 x인 것의 개수를 저장하기
        }
        // 나머지가 x인 경우, 그 중 2개 구간을 선택하기
        // nC2 = n(n-1)/2
        for(int i = 0; i < m; i++) {
            long remainderCount = remainderCountList[i];
            result += remainderCount * (remainderCount-1) / 2;
        }
        System.out.println(result);
    }
}
