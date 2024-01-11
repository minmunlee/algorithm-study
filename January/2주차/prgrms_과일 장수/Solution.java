import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int solution(int k, int m, int[] score) {
        score = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int res = 0;
        int pointer = m - 1;

        while (pointer < score.length) {
            res += score[pointer] * m;
            pointer += m;
        }

        return res;
    }
}
