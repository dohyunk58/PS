package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(b > a) {
            int temp = a;
            a = b; b = temp;
        }

        int gcd = findGcd(a, b);
        System.out.println(gcd);
        System.out.println((a * b) / gcd); // 최소공배수 = a * b / gcd
    }

    // 유클리드 호제법, (a > b) a와 b의 최대공약수는 a를 b로 나눈 나머지 r에 대해 b와 r의 최대공약수와 같으므로, r이 0일때까지 r을 찾는다
    static int findGcd(int a, int b) {
        int remainder = a % b;
        if(remainder == 0) { // 0으로 나누어 떨어질때 마지막으로 나눴던 수 b가 최대공약수이다
            return b;
        }
        return findGcd(b, remainder);
    }
}
