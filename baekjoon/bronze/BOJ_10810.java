package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N M 입력
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 바구니 배열 선언
        String[] arr = new String[N];
        Arrays.fill(arr, "0"); // 0으로 모두 초기화

        for(int x = 0; x < M; x++) {
            // ijk 입력
            String[] ijk = br.readLine().split(" ");
            int i =  Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            String k = ijk[2];

            for(int y = i; y < j+1; y++){
                arr[y-1] = k;
            }
        }

        for(int i = 0; i < N; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
