package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>(n);
        Set<Integer> numberSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers.add(num);
            numberSet.add(num);
        }
        br.close();

        // 정렬
        ArrayList<Integer> sortedList = new ArrayList<>(numberSet);
        Collections.sort(sortedList);

        // Map에 순서 매핑
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }

        // 출력 버퍼에 저장
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(map.get(numbers.get(i))).append(" ");
        }

        System.out.print(sb);
    }
}
