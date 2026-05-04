import java.util.StringTokenizer;

class Solution {
    static int len;
    static int currentTime;
    static int opStart;
    static int opEnd;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        len = hourToMin(video_len);
        currentTime = hourToMin(pos);
        opStart = hourToMin(op_start);
        opEnd = hourToMin(op_end);
        
        opSkip();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) prev();
            else next();
            opSkip();
        }
        
        String answer = minToHour(currentTime);
        return answer;
    }
    
    // prev
    private void prev() {
        currentTime -= 10;
        if (currentTime < 0) currentTime = 0;
    }
    
    // next
    private void next() {
        currentTime += 10;
        if (currentTime > len) currentTime = len;
    }
    
    // opSkip
    private void opSkip() {
        if (currentTime >= opStart && currentTime < opEnd) {
            currentTime = opEnd;
        }
    }
    
    // 문자열 hh:mm -> int min
    private int hourToMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }
    
    // int min -> 문자열 hh:mm
    private String minToHour(int min) {
        int h = min / 60;
        int m = min % 60;
        String strH = Integer.toString(h);
        String strM = Integer.toString(m);
        
        if (h < 10) {
            strH = "0" + strH;
        }
        if (m < 10) {
            strM = "0" + strM;
        }
        
        return (strH + ":" + strM);
    }
}