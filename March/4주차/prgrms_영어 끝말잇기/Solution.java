import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list  = new ArrayList<>(); // 단어를 담을 리스트
        
        for(int i = 0; i < words.length; i++){
            int num = i % n + 1; // 사람 번호
            int turn = i / n + 1; // 탈락 차례
            
            if(list.contains(words[i])){ // 이미 있는 단어를 말할 경우
                answer[0] = num;
                answer[1] = turn;
                break;
            }
            list.add(words[i]);   
            
            if(i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){ // 현재 사람이 말한 단어 앞자리가 앞사람이 말한 단어 끝자리와 다른 단어를 말할 경우
                answer[0] = num;
                answer[1] = turn;
                break;
            }
        }
        return answer;
    }
}