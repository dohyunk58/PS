/*
IDEA 1. 높은 사과 순서대로 배열에 담아서 판매
*/

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        for (int i = 0; i < score.length / 2; i++) { // 내림차순으로 순서 변경
            int temp = score[i];
            score[i] = score[score.length - i - 1];
            score[score.length - i - 1] = temp;
        }
        
        int boxNum = score.length / m; // 박스 개수
        
        int sum = 0; // 각 상자의 최저 점수를 하나씩 저장해 m을 곱하기
        for (int i = 1; i <= boxNum; i++) {
            // 한 박스에 마지막에 들어가는 사과의 점수(가장 작은 수)를 저장하기
            sum += score[m * i - 1];
        }
        
        int answer = sum * m;
        return answer;
    }
}