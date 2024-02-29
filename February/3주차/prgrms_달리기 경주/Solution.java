import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int rank = 0;
        
        for(String s : players){
            map.put(s, rank);
            rank++;
        }
        
        for(int i = 0; i < callings.length; i++){
            int idx = map.get(callings[i]); // 부른 사람의 순위
            int m = idx - 1; // 부른 사람의 앞순위
            
            // 서로 순위 변경
            String tmp = players[m];
            players[m] = players[idx];
            players[idx] = tmp;
            
            map.put(players[m], m);
            map.put(players[idx], idx);
        }
        return players;
    }
}