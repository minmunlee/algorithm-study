import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] scores = new int[3]; // 1-3번 수포자의 점수 배열
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % first.length]){
                scores[0]++;
            }
            if(answers[i] == second[i % second.length]){
                scores[1]++;
            }
            if(answers[i] == third[i % third.length]){
                scores[2]++;
            }
        }
        
        int max = Arrays.stream(scores).max().getAsInt(); // 점수중 가장 큰 값 저장
        
        for(int i=0; i< 3; i++){
            if(max == scores[i]){ // 가장 큰 값과 같은 점수들 리스트에 넣음
                answer.add(i + 1);
            }
        }
        
        return answer;
    }

}