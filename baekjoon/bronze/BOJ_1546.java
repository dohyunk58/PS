package baekjoon.bronze;

import java.io.*;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(arr[i]);
            sum += num;
            if(num > max) max = num;
        }

        bw.write(Double.toString((double)sum/n/max*100));
        bw.flush();
        bw.close();
    }
}
