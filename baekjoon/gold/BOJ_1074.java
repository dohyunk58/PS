package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        sum = 0;
        findSquare(size, r, c);
        System.out.print(sum);
    }

    static void findSquare(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        // 중앙 찾기
        int m = size / 2;

        // 사분면 중 위치 찾기
        // 위치한 사분면을 0,0 기준으로 r,c 좌표 재설정
        int quadrant = 0;
        if (r < m && c < m) quadrant = 1;
        else if (r < m && c >= m) {
            quadrant = 2;
            c -= m;
        }
        else if (r >= m && c < m) {
            quadrant = 3;
            r -= m;
        }
        else {
            quadrant = 4;
            r -= m;
            c -= m;
        }

        // 위치한 사분면 이전의 사분면을 합에 추가하기 (3사분면이면 1,2사분면 추가)
        sum += (quadrant-1) * (m * m);

        // 재설정된 좌표로 위 내용을 반복
        findSquare(m, r, c);
    }
}
