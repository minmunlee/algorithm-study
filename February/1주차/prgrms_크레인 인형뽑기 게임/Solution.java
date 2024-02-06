import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0, tmp;
        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                tmp = board[j][moves[i] - 1];
                board[j][moves[i] - 1] = 0;

                if (tmp != 0) {
                    if (!bucket.isEmpty() && bucket.peek() == tmp) {
                        bucket.pop();
                        answer += 2;
                    } else
                        bucket.push(tmp);
                    break;
                }
            }
        }

        return answer;
    }
}