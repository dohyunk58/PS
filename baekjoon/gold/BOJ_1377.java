package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];
        for(int i = 0; i < n; i++) {
            data[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(data);
        int min = 0;
        for(int i = 0; i < n; i++) {
            int diff = i - data[i].index;
            if(min > diff) min = diff;
        }

        System.out.println(Math.abs(min) + 1);
    }

    static class Data implements Comparable<Data> {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }

        // 두 Data 객체의 value 값 차를 반환
        // 음수인 경우 객체 자신이 왼쪽으로 이동해야함
        @Override
        public int compareTo(Data o) {
            // this: 객체 자신
            // o: 비교대상
            return this.value - o.value;
        }
    }
}
