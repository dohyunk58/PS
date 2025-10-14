package baekjoon.bronze;

import java.io.*;

public class BOJ_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i < N+1; i++) {
            for(int j = N - i; j > 0; j--){
                bw.write(" ");
            }
            for(int j = 1; j < i+1; j++ ) {
                bw.write("*");
            }
            if(i != N) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
