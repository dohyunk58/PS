package groom.L2;

import java.io.*;
import java.util.*;

public class groom_347608 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n+1];
        int[] S = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + numbers[i];
        }

        int length = 1;
        while (length <= n) {
            int front = 1;
            int end = front + length - 1;
            while (end <= n) {
                if (S[end++] - S[front++ - 1] >= k) {
                    System.out.print(length);
                    return;
                }
            }
            length++;
        }

        System.out.print(0);
    }
}
