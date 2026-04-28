package baekjoon.bronze;

import java.io.*;

public class BOJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 9; i++) {
            input = br.readLine();
            int num = Integer.parseInt(input);
            if (num > max) {
                max = num;
                maxIndex = i + 1;
            }
        }
        bw.write(max + "\n" + maxIndex);
        bw.flush();
        bw.close();
    }
}
