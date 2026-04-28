package baekjoon.bronze;

import java.io.*;

public class BOJ_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        int num = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < N; i++) {
            if(Integer.parseInt(arr[i]) == num) result++;
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
