import java.util.*;

class Solution {
    private Map<String, Integer> rankMap; // 이름으로 등수 찾기
    private String[] playerList; // 등수로 이름 찾기
    
    public String[] solution(String[] players, String[] callings) {
        this.rankMap = new HashMap<String, Integer>();
        this.playerList = new String[players.length];
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
            playerList[i] = players[i];
        }
        
        // 이름 부르기: 부른 선수의 등수를 찾고 그 앞 등수와 교체
        for (String c : callings) {
            // 부른 선수 등수 찾기
            int rank = rankMap.get(c);
            // 추월당하는 선수 이름
            String frontPlayer = playerList[rank-1];
            
            // 앞 등수와 교체
            rankMap.put(c, rank-1);
            rankMap.put(frontPlayer, rank);
            
            playerList[rank-1] = c;
            playerList[rank] = frontPlayer;
        }
        
        return playerList;
    }
}