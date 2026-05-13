class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // 3월 4일인 경우, 그전 달(1, 2월)까지의 모든 날을 더한다
        int daySum = b;
        while (a > 1) {
            daySum += month[--a];
        }
        
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}; // 1일 금요일을 시작으로 7(0)일은 목요일
        
        return day[daySum % 7];
    }
}