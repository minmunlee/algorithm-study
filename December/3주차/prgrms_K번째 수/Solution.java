import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int t=0;t<commands.length;t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            int[] rangeArray = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(rangeArray);
            answer[t] = rangeArray[k-1];
        }
        return answer;
    }
}