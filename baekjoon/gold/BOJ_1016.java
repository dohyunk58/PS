package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int range = (int) (max - min + 1);
        boolean[] isSquare = new boolean[range];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;

            // i^2의 배수 중 min 값보다 큰 수부터 시작하기
            long start = min / square;
            if (min % square != 0) start++;


            // 제곱수 확인
            for (long j = start; j * square <= max; j++) {
                int index = (int) (j * square - min);
                isSquare[index] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < range; i++) {
            if (!isSquare[i]) count++;
        }

        System.out.print(count);
    }
}
