import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<String,Integer> count = new HashMap<>();
        String[] cList = s.split("");
        for(int i=0;i<answer.length;i++){
            String c = cList[i];
            int close = i - count.getOrDefault(c, i+1);
            answer[i] = close;
            count.putIfAbsent(c, i);
            count.replace(c, i);
        }
        return answer;
    }
}