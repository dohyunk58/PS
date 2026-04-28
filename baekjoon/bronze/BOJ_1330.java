package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        if(num1 < num2) System.out.println("<");
        else if (num1 > num2) System.out.println(">");
        else System.out.println("==");
    }
}
