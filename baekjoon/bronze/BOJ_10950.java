package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(num1+num2));
            if(i!=N-1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
