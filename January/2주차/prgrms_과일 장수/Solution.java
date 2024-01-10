import java.util.*;

// 사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        if(score.length % m == 0){ // 상자에 사과가 딱 맞게 들어 갈 경우
            for(int i = 0; i < score.length / m; i++){
                answer += score[i * m] * m; // 
            }
        }else{
            for (int i = score.length % m; i < score.length; i += m) { // 딱 맞게 들어가지 않을 경우 나머지 값들의 점수
                answer += score[i] * m;
            }

        }
        return answer;
    }
}