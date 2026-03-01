package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<>(n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            sum += num;
            numbers.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(numbers);

        // 1. 산술 평균
        sb.append((int)Math.round(sum/(double)n)).append("\n");

        // 2. 중앙값
        sb.append(numbers.get(n/2)).append("\n");

        // 3. 최빈값
        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(maxCount, count);
        }

        List<Integer> modeList = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                modeList.add(key);
            }
        }
        Collections.sort(modeList);

        if (modeList.size() > 1) {
            sb.append(modeList.get(1)).append("\n");
        } else {
            sb.append(modeList.get(0)).append("\n");
        }

        // 4. 범위
        sb.append(numbers.get(n-1) - numbers.get(0));

        System.out.print(sb);
    }
}
