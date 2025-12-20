package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    첫 자리 숫자 2,3,5,7
    이후 숫자 홀수만
 */

public class BOJ_2023 {
    public static int n;
    public static int[] secondPrimeNumbers = new int[] {1,3,7,9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    public static void dfs(int number, int length) {
        if(length == n) {
            System.out.println(number);
            return;
        }
        for(int i : secondPrimeNumbers) {
            int nextNumber = number * 10 + i;
            if(isPrime(nextNumber)) {
                dfs(nextNumber, length+1);
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
