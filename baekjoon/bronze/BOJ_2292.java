package baekjoon.bronze;

/*
 입력값 N이 6*addLength+1 보다 작거나 같으면 거리 i
 크다면 addLength는 i만큼 증가

 6 * addLength + 1이 기준인 이유
 - N <= 1 (6 * 0 + 1)이면 거리 1
 - N <= 7 (6 * 1 + 1)이면 거리 2
 - N <= 19 (6 * 3 + 1)이면 거리 3
 - N <= 37 (6 * 6 + 1)이면 거리 4
 이때 6에 곱하는 수는 0, 1, 3, 6, 10 ... 으로 늘어난다. 이를 는 기존 수에 1,2,3,4 ... 만큼 더한 값이며 이를 구현하기 위해 i를 두어 반복마다 늘어나도록 했다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());

        long addLength = 0;
        int distance = 0;
        for(int i = 1;; i++) {
            if(n <= (6 * addLength + 1)) {
                distance = i;
                break;
            }

            addLength += i;
        }

        bw.write(Long.toString(distance));
        bw.flush();
        bw.close();
    }
}
