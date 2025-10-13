package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = str.chars()
                        .map(c->c-'0')
                                .sum();

        System.out.println(sum);
    }
}

/* String으로 입력받아 charAt() 메서드 사용
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());

    String str = br.readLine();

    int sum = 0;
    for(int i = 0; i < testcases; i++) {
        sum += str.charAt(i)-'0';
    }

    System.out.println(sum);
}
*/
