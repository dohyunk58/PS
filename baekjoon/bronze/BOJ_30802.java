package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tNumbers = new int[6];
        for(int i = 0; i < 6; i++) {
            tNumbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tSets = 0;
        for(int i = 0; i < 6; i++) {
            tSets += (tNumbers[i] / t) + 1;
            // 나눠 떨어질 때
            if(tNumbers[i] % t == 0){
                tSets--;
            }
        }
        System.out.println(tSets);
        System.out.println((n / p) + " " + (n % p));
    }
}
