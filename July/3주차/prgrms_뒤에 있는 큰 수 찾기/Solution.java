import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = numbers.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){ // 현재 수보다 작을 경우
                stack.pop();
            }
            
            if(stack.isEmpty()){
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }

        return answer;
    }
}