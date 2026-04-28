package baekjoon.bronze;

import java.io.*;

public class BOJ_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; i++){
            bw.write(num + " * " + i + " = " + num*i);
            if(i != 9) bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}
