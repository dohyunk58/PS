package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.parseInt(br.readLine());
        int testcases = Integer.parseInt(br.readLine());

        while(testcases-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            result -= (price * amount);
        }

        bw.write((result == 0) ? "Yes" : "No");

        bw.flush();
        bw.close();
    }
}
