package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long r = 1;
        long M = 1234567891;
        long hashSum = 0;

        for(int i = 0; i < n; i++) {
            int number = str[i] - 'a' + 1;
            hashSum += (number * r) % M;
            hashSum %= M;
            r = (r * 31) % M;
        }

        System.out.println(hashSum);
    }
}
