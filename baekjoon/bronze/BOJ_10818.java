package baekjoon.bronze;

import java.io.*;

public class BOJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(arr[i]);
            if(num < min) min = num;
            if(num > max) max = num;
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }
}
