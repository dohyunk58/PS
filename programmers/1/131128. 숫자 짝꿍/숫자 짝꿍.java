/*
1. 입력 숫자에 각 자릿수를 확인해 각 숫자가 몇개있는지 확인(0~9)
2. 큰 수(9)부터 숫자의 개수 중 작은 값을 문자열에 추가 후 출력

시간 초과가 난 이유: String += String, String은 불변 객체로 + 연산을 하면 계속 새로운 객체를 생성함
*/
class Solution {
    public String solution(String X, String Y) {
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        
        int[] xNum = new int[10];
        int[] yNum = new int[10];
        
        for (char c : x) {
            xNum[c-'0']++;
        }
        for (char c : y) {
            yNum[c-'0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int cnt = Math.min(xNum[i], yNum[i]);
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }
        
        // -1, 0 예외 처리
        if (sb.length() == 0) {
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        }
        
        String answer = sb.toString();
        return answer;
    }
}