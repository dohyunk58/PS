class Solution {
    public boolean solution(int x) {
        char[] number = String.valueOf(x).toCharArray();
        int sum = 0;
        for (char c : number) {
            sum += c - '0';
        }
        
        return (x % sum == 0);
    }
}