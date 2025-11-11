package baekjoon.bronze;

/*
N = 0, 한 줄에 점 2개, 총 점의 개수 4개 (2^2)
N = 1, 한 줄 점 2+1개 = 2^1+1, 총 점 3^2
N = 2, 한 줄 점 3+2 = 2^2+1, 총 점 5^2
N = 3, 한 줄 점 5+4 = 2^3+1, 총 점 9^2
N = x, 한 줄 점 2^x+1, 총 점 (2^x+1)^2
 */

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println((int)Math.pow((Math.pow(2,n)+1),2));
    }
}
