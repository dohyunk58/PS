package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class BOJ_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Boolean[] arr = new Boolean[30];
        Arrays.fill(arr, false);

        for(int i = 0; i < 28; i++){
            arr[Integer.parseInt(br.readLine())-1] = true;
        }

        for(int i = 0; i < 30; i++){
            if(!arr[i]){bw.write(i+1 + "\n");}
        }

        bw.flush();
        bw.close();
    }
}
