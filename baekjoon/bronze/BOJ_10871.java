package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String[] arr = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            if(Integer.parseInt(arr[i]) < X) {
                bw.write(arr[i]);
                if(i < N-1) bw.write(" ");
            }
        }

        bw.flush();
        bw.close();
    }
}
