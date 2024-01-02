import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(score[0]);
        answer[0] = score[0];
        for(int i=1;i<score.length;i++){
            int lastIndex = (i<k)?arr.size()-1:k-1;
            int nextScore = score[i];
            if(arr.get(lastIndex)<=nextScore){
                for(int navi=0;navi<=lastIndex;navi++){
                    if(arr.get(navi)>nextScore) continue;
                    arr.add(navi, nextScore);
                    break;
                }
            }else arr.add(nextScore);
            if(i<k) lastIndex++;
            answer[i] = arr.get(lastIndex);
        }
        return answer;
    }
}
