package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2720 {
    private final static int QUARTER = 25;
    private final static int DIME = 10;
    private final static int NICKEL = 5;
    private final static int PENNY = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tryNum = Integer.parseInt(st.nextToken());
        int[] changeCount = new int[4];
        for(int i = 0; i < tryNum; i++) {
            st = new StringTokenizer(br.readLine());
            int change = Integer.parseInt(st.nextToken());

            changeCount[0] = change / QUARTER; change %= QUARTER;
            changeCount[1] = change / DIME; change %= DIME;
            changeCount[2] = change / NICKEL; change %= NICKEL;
            changeCount[3] = change / PENNY; change %= PENNY;

            for(int count : changeCount) {
                bw.write(count + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
