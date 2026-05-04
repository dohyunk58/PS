import java.util.StringTokenizer;

class Solution {
    private int len;
    private int currentTime;
    private int opStart;
    private int opEnd;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.len = toSeconds(video_len);
        this.currentTime = toSeconds(pos);
        this.opStart = toSeconds(op_start);
        this.opEnd = toSeconds(op_end);

        opSkip();

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                currentTime = Math.max(0, currentTime - 10);
            } else {
                currentTime = Math.min(len, currentTime + 10);
            }
            opSkip();
        }

        return formatTime(currentTime);
    }

    // opSkip
    private void opSkip() {
        if (currentTime >= opStart && currentTime < opEnd) {
            currentTime = opEnd;
        }
    }

    // 문자열 mm:ss -> int sec
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // int min -> 문자열 hh:mm
    private String formatTime(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }
}