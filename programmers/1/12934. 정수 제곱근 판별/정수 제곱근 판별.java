class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);

        // 다시 제곱했을 때 n이 나오면 n은 정수의 제곱수
        if (sqrt * sqrt == n) {
            return (sqrt + 1) * (sqrt + 1);
        }

        return -1;
    }
}