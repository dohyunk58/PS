class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if ((n/i) != i) {
                    answer = answer + i + (n / i);
                } else {
                    answer += i;
                }  
            }
        }
        
        return answer;
    }
}