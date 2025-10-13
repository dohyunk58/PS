package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M < 45){
            if(H == 0){ // 0시 && 45분 이전
                H = 23;
                M += 15;
            }
            else {
                H -= 1;
                M += 15;
            }
        }
        else M -= 45;

        System.out.println(H + " " + M);
    }
}
