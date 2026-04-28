package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int addM = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(str);
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        H = (H + ((M+addM) / 60)) % 24;
        M = (M+addM) % 60;

        System.out.println(H + " " + M);
    }
}
