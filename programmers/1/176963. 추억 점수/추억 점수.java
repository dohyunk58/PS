import java.util.*;

class Solution {
    private Map<String, Integer> map;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        this.map = new HashMap<String, Integer>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                result[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        
        return result;
    }
}