import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        StringBuilder sb;
        int[] tempArr = {};

        for (int i = 0; i < commands.length; i++) {
            tempArr = Arrays.stream(Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]))
                    .sorted().toArray();
            answer[i] = tempArr[commands[i][2] - 1];
        }

        return answer;
    }
}