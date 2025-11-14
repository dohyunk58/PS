package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2869 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.print((int)Math.ceil((double)(v-a) / (a-b)) + 1);
    }
}