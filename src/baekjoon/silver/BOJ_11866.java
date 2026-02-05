package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        int index = 0;
        while (true) {
            index = (index + (k-1)) % list.size(); // <7,3> 0 -> 2 -> 4 -> 1
            int num = list.remove(index);
            if (list.isEmpty()) {
                sb.append(num);
                break;
            } else {
                sb.append(num).append(", ");
            }
        }

        sb.append(">");
        System.out.print(sb);
    }
}
