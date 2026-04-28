package baekjoon.silver;

import java.io.*;

public class BOJ_1193 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int groupSize = 0;

        while(n > 0) {
            groupSize++;
            n -= groupSize;
        }

        // groupSize: N이 속한 그룹의 크기
        // N: 해당 그룹에서 뒤에서 몇 번째 숫자인지 (ex. 0 = 맨뒤에서 1번째, -1 = 맨 뒤에서 2번째)
        // 그룹이 홀수번째라면 그룹크기/1 ~ 1/그룹크기
        // 그룹이 짝수번째라면 1/그룹크기 ~ 그룹크기/1

        int i = 0; int j = 0;
        if(groupSize %2 == 0) { // 짝수 그룹
            i = groupSize; j = 1; // 짝수 그룹 뒤부터
            for(int k = 0; k > n; k--) { // n번째가 될때까지 뒤에서부터 숫자 탐색
                i--; j++;
            }
        } else {
            i = 1; j = groupSize; // 홀수 그룹 뒤부터
           for(int k = 0; k > n; k--) {
               i++; j--;
           }
        }

        System.out.println(i+"/"+j);
    }
}
