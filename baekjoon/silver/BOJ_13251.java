package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        int[] colors = new int[m];
        int n = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            n += colors[i];
        }

        int k = Integer.parseInt(br.readLine());
        br.close();

        // 각 색별로 확률 구하기
        double result = 0.0;
        for (int i = 0; i < m; i++) {
            // 뽑는 공의 수가 각 색의 공의 수보다 크면 확률을 구하기
            if (colors[i] >= k) {
                double p = 1.0;
                for (int j = 0 ; j < k; j++) {
                    p *= (double) (colors[i] - j) / (n - j);
                }
                result += p;
            }
        }
        System.out.print(result);
    }
}
