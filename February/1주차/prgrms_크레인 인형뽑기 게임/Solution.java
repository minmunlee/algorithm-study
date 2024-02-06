import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int m : moves){
            for(int i = 0; i < board.length; i++){
                int doll = board[i][m - 1]; // 인형 위치
                if(doll != 0){
                    if(stack.empty()){
                        stack.push(doll);
                    }else if(doll == stack.peek()){
                        answer += 2;
                        stack.pop();
                    }else{
                       stack.push(doll);
                    }
                    board[i][m - 1] = 0; // 뽑은 인형은 0으로 바꿈
                    break;
                } 
            }
        }
        return answer;
    }
}
