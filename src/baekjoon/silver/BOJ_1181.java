package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BOJ_1181 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 중복 제거
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<String>(set);

        // 선택 정렬: 0부터 n-1까지의 요소를 각각 비교
        for(int i = 0; i < list.size()-1; i++) {
            int min = i;
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(min).length() > list.get(j).length()) { // min 번째 값이 j번째 보다 길다 -> j를 min에 저장
                    min = j;
                }
                else if(
                        list.get(min).length() == list.get(j).length() // 둘의 길이가 같을 때
                                && (list.get(min).compareTo(list.get(j)) > 0)) { // min > j => min = j
                    min = j;
                }
            }
            Collections.swap(list, i, min);
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}