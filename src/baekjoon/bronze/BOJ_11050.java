package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// nCk = n! / (k! * (n-k)!)
public class BOJ_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long result = factorial(n) / (factorial(k) * factorial(n-k));
        System.out.println(result);
    }

    private static long factorial(int a) {
        if(a <= 0) return 1;
        long result = 1;
        for(int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}
