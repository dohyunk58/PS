class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'p' || current =='P') {
                pCnt++;
            } else if (current == 'y' || current =='Y') {
                yCnt++;
            }
        }

        return (pCnt == yCnt);
    }
}