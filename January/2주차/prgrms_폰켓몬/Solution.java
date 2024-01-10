import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choice = nums.length / 2; // 선택 할 수 있는 포켓몬의 개수
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){ // nums 에서 이미 중복되는 값들을 제거한 리스트
                list.add(nums[i]);
            }
        }
        
        if(choice <= list.size()){
            return answer = choice;
        }else{
            return answer = list.size();
        }
    }
}