import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] tmp = {};
        
        for(int i = 0; i < commands.length; i++){
            tmp = IntStream.range(commands[i][0] - 1, commands[i][1]).map(num -> array[num]).toArray();
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];

        }
        
        return answer;
    }
}