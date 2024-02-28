import java.util.*;
class Solution {
    HashMap<String, Integer> playerRank = new HashMap<>();
    TreeMap<Integer, String> rankMap = new TreeMap<>();
    public String[] solution(String[] players, String[] callings) {
        for(int i=0;i<players.length;i++) {
            playerRank.put(players[i], i+1);
            rankMap.put(i+1, players[i]);
        }
        for(String callingPlayer : callings) {
            int callingPlayerRank = playerRank.get(callingPlayer);
            String frontPlayer = rankMap.get(callingPlayerRank-1);
            
            rankMap.replace(callingPlayerRank-1, callingPlayer);
            rankMap.replace(callingPlayerRank, frontPlayer);
            
            playerRank.replace(callingPlayer, callingPlayerRank-1);
            playerRank.replace(frontPlayer, callingPlayerRank);
        }
        String[] answer = new String[players.length];
        int i=0;
        for(Map.Entry<Integer, String> entry : rankMap.entrySet()) {
            answer[i] = entry.getValue();
            i++;
        }
        return answer;
    }
}