import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> count = new HashMap<>();
        for(String[] cloth : clothes) {
            count.put(cloth[1], count.getOrDefault(cloth[1], 0) + 1);
        }
        for(String key : count.keySet()) {
            answer *= count.get(key) + 1;
        }
        return answer-1;
    }
}