import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Character, Integer> indicator = new HashMap<>();

    public static String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();

        indicator.put('R', 0);
        indicator.put('T', 0);
        indicator.put('C', 0);
        indicator.put('F', 0);
        indicator.put('J', 0);
        indicator.put('M', 0);
        indicator.put('A', 0);
        indicator.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] < 4) { //1 ~ 3중 하나인지 (비동의 관련)
                indicator.put(survey[i].charAt(0), indicator.get(survey[i].charAt(0)) + 4 - choices[i]);
            } else if (choices[i] >= 5) { //5 ~ 7중 하나인지 (동의 관련)
                indicator.put(survey[i].charAt(1), indicator.get(survey[i].charAt(1)) + choices[i] - 4);
            }
        }

        sb.append(getMax('R', 'T'));
        sb.append(getMax('C', 'F'));
        sb.append(getMax('J', 'M'));
        sb.append(getMax('A', 'N'));

        return sb.toString();
    }

    public static char getMax(char key1, char key2) {
        int score1 = indicator.get(key1);
        int score2 = indicator.get(key2);

        if (score1 != score2)
            return (score1 > score2) ? key1 : key2;
        else // 점수가 같을 경우 사전 순서로 비교
            return (String.valueOf(key1).compareTo(String.valueOf(key2)) < 0) ? key1 : key2;
    }
}