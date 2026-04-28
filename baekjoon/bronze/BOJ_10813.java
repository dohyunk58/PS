package baekjoon.bronze;

import java.io.*;

public class BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        for(int x = 0; x < M; x++){
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0])-1;
            int j = Integer.parseInt(ij[1])-1;

            int cmp = arr[i];
            arr[i] = arr[j];
            arr[j] = cmp;
        }

        for(int i = 0; i < N; i++){
            bw.write(arr[i]+" ");
        }

        bw.flush();
        bw.close();
    }
}
