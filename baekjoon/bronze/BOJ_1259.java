package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String number = br.readLine();
            if(number.equals("0")) break;

            int front = 0;
            int rear = number.length()-1;

            char[] numbers = number.toCharArray();
            boolean isPalindrome = true;
            while(front <= rear) {
                if(numbers[front++] != numbers[rear--]) {
                    isPalindrome = false;
                }
            }

            if(isPalindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
