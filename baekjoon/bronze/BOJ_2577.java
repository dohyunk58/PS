package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        char[] multiplied = Integer.toString(a * b * c).toCharArray();
        int[] result = new int[10];

        for(int i = 0; i < multiplied.length; i++) {
            int number = multiplied[i] - '0';
            result[number]++;
        }

        for(int i = 0; i <= 9; i++) {
            System.out.println(result[i]);
        }
    }
}