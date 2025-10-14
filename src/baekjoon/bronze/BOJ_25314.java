package baekjoon.bronze;

import java.io.*;

import static java.lang.Math.floor;

public class BOJ_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        N = (int)floor(N / 4.0); // N = 16 -> 4, 15 -> 4

        for(int i = 0; i < N; i++){
            bw.write("long ");
        }
        bw.write("int");
        bw.flush();
        bw.close();
    }
}
