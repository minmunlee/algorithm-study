import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            int count = map.getOrDefault(p, 0);
            map.put(p, ++count);
        }
        for(String c : completion) {
            int count = map.get(c);
            map.replace(c, --count);
            if(count==0) map.remove(c);
        }
        String answer = "";
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            answer = key;
        }
        return answer;
    }
}