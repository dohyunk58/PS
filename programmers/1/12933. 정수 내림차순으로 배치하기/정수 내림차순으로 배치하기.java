import java.util.*;

class Solution {
    public long solution(long n) {
        int[] counts = new int[10];
        
        while (n > 0) {
            counts[(int)(n % 10)]++;
            n /= 10;
        }
        
        long answer = 0;
        for (int i = 9; i >= 0; i--) {
            while (counts[i] > 0) {
                answer = answer * 10 + i;
                counts[i]--;
            }
        }
        
        return answer;
    }
}