package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static int[] count;
    static int[] checkCount;
    static int passwordCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = new int[4];
        checkCount = new int[4];
        passwordCount = 0;

        // 첫번째 줄
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 두번째 줄
        char[] dnaArr = new char[s];
        dnaArr = br.readLine().toCharArray();

        // 세번째 줄
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            checkCount[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 배열 체크
        for(int i = 0; i < p; i++) {
            add(dnaArr[i]);
        }
        if(checkCountAll()) passwordCount++;

        // 배열을 오른쪽으로 한 칸씩 이동
        for(int i = p; i < s; i++) {
            remove(dnaArr[i-p]); // 왼쪽 요소 제거
            add(dnaArr[i]);
            if(checkCountAll()) passwordCount++;
        }

        System.out.println(passwordCount);
        br.close();
    }

    static void add(char c) {
        switch (c) {
            case 'A':
                count[0]++;
                break;
            case 'C':
                count[1]++;
                break;
            case 'G':
                count[2]++;
                break;
            case 'T':
                count[3]++;
                break;
        }
    }

    static void remove(char c) {
        switch(c) {
            case 'A':
                count[0]--;
                break;
            case 'C':
                count[1]--;
                break;
            case 'G':
                count[2]--;
                break;
            case 'T':
                count[3]--;
                break;
        }
    }

    // 요구치보다 많은지 확인
    static boolean checkCountAll() {
        boolean flag = true;
        for(int i = 0; i < 4; i++) {
            if(count[i] < checkCount[i]) {
                flag = false;
            }
        }
        return flag;
    }
}
