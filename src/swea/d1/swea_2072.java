package swea.d1;

import java.io.*;
import java.util.StringTokenizer;

public class swea_2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            int sums = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 != 0) {
                    sums += num;
                }
            }

            System.out.println("#"+(i+1)+" "+sums);
        }
    }
}
