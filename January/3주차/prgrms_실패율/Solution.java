import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stagePlayers = new int[N+2];
        for(int s : stages) {
            stagePlayers[s]++;
        }
        Map<Integer,Double> stageRate = new HashMap<>();
        int reachedPlayers = stagePlayers[N+1];
        for(int stageNumber=N;stageNumber>0;stageNumber--){
            double nonClear = stagePlayers[stageNumber];
            reachedPlayers += nonClear;
            double failureRate = (reachedPlayers==0)?0:nonClear/reachedPlayers;
            stageRate.put(stageNumber, failureRate);
        }
        List<Integer> keys = new ArrayList<>(stageRate.keySet());
        Collections.sort(keys, (v1, v2) -> (stageRate.get(v2).compareTo(stageRate.get(v1)))); 
        int[] answer = keys.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}