import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int notLost = n - lost.length; // 잃어버리지 않은 사람
        int borrow = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여분을 가지고 온 사람이 잃어버렸을 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    borrow++;
                    reserve[j] = -31; // 학생수가 30명 이하라서 -31부터 줬음 (0으로 주니까 테스트 실패뜸 왜죠)
                    lost[i] = -41;
                    break;
                }
            }
        }
        
        // 여분이 없는 사람 중 잃어버린 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){ // 앞 뒤 사람이 여분이 있는지 확인
                    borrow++;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        
        answer = borrow + notLost;
        return answer;
    }
}