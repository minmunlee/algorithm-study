import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String s : participant){
            map.put(s, map.getOrDefault(s, 0) + 1); // 참가 선수 정보 넣기
        }
        
        for(String s : completion){
            map.put(s, map.get(s) - 1); // 완주 한 선수는 value 값을 지우기
        }
        
        for(String s : map.keySet()){
            if(map.get(s) != 0){ // 완주 하지 못한 선수
                answer += s;
            }
        }
        return answer;
    }
}