package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2480 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;
        if(a==b && a==c) result = 10000+a*1000;
        else if(a==b || a==c) result = 1000+a*100;
        else if(b==c) result = 1000+b*100;
        else {
            if(a > b && a > c) result = a*100;
            else if(b > a && b > c) result = b*100;
            else result = c*100;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
