package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startMoney = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        Person A = new Person(startMoney);
        if (A.balance >= prices[0]) {
            A.stock += A.balance / prices[0];
            A.balance %= prices[0];
        }

        Person B = new Person(startMoney);
        int upCnt = 1;
        int downCnt = 1;
        for (int i = 1; i < 14; i++) {
            // A
            if (A.balance >= prices[i]) {
                A.stock += A.balance / prices[i];
                A.balance %= prices[i];
            }

            // B
            if (prices[i-1] < prices[i]) { // 가격 상승시
                upCnt++;
                downCnt = 0;
                if (upCnt >= 3) { // 3일 이상 상승 시 판매
                    B.balance += B.stock * prices[i];
                    B.stock = 0;
                }
            } else if (prices[i-1] > prices[i]) { // 가격 하락시
                downCnt++;
                upCnt = 0;
                if (downCnt >= 3 && B.balance >= prices[i]) { // 3일 이상 시 구매
                    B.stock += B.balance / prices[i];
                    B.balance %= prices[i];
                }
            } else { // 동결
                downCnt = 0;
                upCnt = 0;
            }
        }
        br.close();

        // 마지막 날 남은 주식 판매
        A.balance += A.stock * prices[13];
        B.balance += B.stock * prices[13];

        if (A.balance > B.balance) System.out.print("BNP");
        else if (B.balance > A.balance) System.out.print("TIMING");
        else System.out.print("SAMESAME");
    }

    static class Person {
        int balance;
        int stock;

        public Person(int b) {
            this.balance = b;
            this.stock = 0;
        }
    }
}
