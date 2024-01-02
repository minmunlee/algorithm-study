import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++){
            if(list.size() < k){ // 명예의 전당 자리가 남아 있는 경우
                list.add(score[i]);
                Collections.sort(list);
                answer[i] = list.get(0);
             }else if(list.size() == k){ // 자리가 가득 찬 경우
                list.add(score[i]);
                Collections.sort(list);
                list.remove(list.get(0));
                answer[i] = list.get(0);
            }

        }
        return answer;
    }
}