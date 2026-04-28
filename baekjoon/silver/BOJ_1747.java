package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n <= 1) n = 2;
        int rootMax = (int)Math.sqrt(11_000_000);

        boolean[] isPrime = new boolean[11_000_000+1];

        for (int i = 2; i <= 11_000_000; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체로 루트 N까지의 소수 구하기
        for (int i = 2; i <= rootMax; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * 2; j <= 11_000_000; j = j + i) {
                isPrime[j] = false;
            }
        }

        for (int i = n; i <= 11_000_000; i++) {
            // 소수
            if (isPrime[i] && isPalindrome(i)) {
                System.out.print(i);
                break;
            }
        }
    }

    public static boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
