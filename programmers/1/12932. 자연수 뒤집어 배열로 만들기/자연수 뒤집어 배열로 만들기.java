class Solution {
    public int[] solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            answer[i] = chars[chars.length - i - 1] - '0';
        }
        return answer;
    }
}