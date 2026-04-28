package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int floor = n % h; int room = n / h + 1;
            if(floor == 0) { // 꼭대기층
                floor = h;
                room = n / h;
            }
            System.out.printf("%d%02d\n", floor, room);
        }
    }
}
