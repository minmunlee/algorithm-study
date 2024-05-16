import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>(); // 의상 종류별 개수
        
        for(int i = 0; i < clothes.length; i++){
            if(hm.containsKey(clothes[i][1])){
                hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
            }else{
                hm.put(clothes[i][1], 1);
            }
        }
        
        for(int i : hm.values()){
            answer *= i + 1; // 안입기까지 합쳐서 1 더하기
        }
        return answer - 1; // 아예 안입는건 안됨 
    }
}