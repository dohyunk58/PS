package baekjoon.bronze;

import java.io.*;
import java.util.stream.IntStream;

public class BOJ_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = IntStream.rangeClosed(1, n).toArray();

        for(int k = 0; k < m; k++){
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0])-1;
            int j = Integer.parseInt(ij[1])-1;

            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        for(int i = 0; i < n; i++){
            bw.write(arr[i]+" ");
        }

        bw.flush();
        bw.close();
    }
}