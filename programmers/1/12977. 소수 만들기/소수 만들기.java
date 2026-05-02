class Solution {
    static boolean[] isPrime;
    static int MAX = 2997;
    
    public int solution(int[] nums) {
        // 합의 최대치인 2997까지 소수 판별
        isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i <= Math.sqrt(MAX) + 1; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // nC3으로 i, j, k 세 숫자 조합이 소수인지 확인
        // i: 0~len-3, j: i+1~len-2, k: j+1~len-1
        int len = nums.length;
        int primeCnt = 0;
        for (int i = 0; i <= len-3; i++) {
            for (int j = i+1; j <= len-2; j++) {
                for (int k = j+1; k <= len-1; k++) {
                    if (isPrime[(nums[i] + nums[j] + nums[k])]) {
                        primeCnt++;
                    }
                }
            }
        }
        
        int answer = primeCnt;

        return answer;
    }
}