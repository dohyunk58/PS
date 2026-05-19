class Solution {
    public long solution(int a, int b) {
        
        if (b < a) {
            int temp = b;
            b = a;
            a = temp;
        }
        long answer = (long)((a+b)/2.0 * (long)(b-a+1)); 
        return answer;
    }
}