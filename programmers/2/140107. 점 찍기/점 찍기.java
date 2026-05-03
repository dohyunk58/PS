/*
x^2 + y^2 <= d^2, y <= sqrt(d^2 - x^2)으로 y의 최댓값 구하기
*/

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        // x축 위의 한 값에 대한 y축의 최대값을 구하여 점의 개수 세기
        for (long x = 0; x <= d; x += k) {
            long yMax = (long)Math.sqrt((long)d*d - x*x);
            answer += (yMax / k) + 1; // 0도 포함
        }
        
        
        return answer;
    }
}