package baekjoon.bronze;

import java.io.*;
import java.util.HashSet;

public class BOJ_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < 10; i++){
            set.add(Integer.parseInt(br.readLine()) % 42);
        }

        bw.write(Integer.toString(set.size()));
        bw.flush();
        bw.close();
    }
}
