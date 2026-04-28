package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String passwd = st.nextToken();

            map.put(site, passwd);
        }

        for (int i = 0; i < m ; i++) {
            String str = br.readLine();
            sb.append(map.get(str)).append("\n");
        }
        System.out.print(sb);
    }
}
