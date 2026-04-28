package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> trees = new ArrayList<>(n);

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            trees.add(num);
            max = Math.max(max, num);
        }

        long low = 0;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long woodSum = 0;

            for (int tree : trees) {
                if (tree > mid) woodSum += (tree - mid);
            }

            // 합이 요구치보다 높으면 나무 함을 최소한으로 줄이기위해 높이(mid)를 높이기
            if (woodSum >= m) {
                result = mid;
                low = mid + 1;
            } else { // 합이 낮으면 자르는 높이(mid)를 낮추기
                high = mid - 1;
            }
        }

        System.out.print(result);
    }
}
