package baekjoon.bronze;

import java.io.*;

public class BOJ_8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 1; i < N + 1; i++){
            sum += i;
        }

        bw.write(Integer.toString(sum));

        bw.flush();
        bw.close();
    }
}
