package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcases = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(a+b));
            if(i != testcases-1) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
