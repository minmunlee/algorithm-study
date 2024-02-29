import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int[][] table = new int[friends.length][friends.length]; // 한 사람당 선물을 주고 받은 개수 배열 (열: 준 사람, 행: 받은 사람)
        int[] presents = new int[friends.length]; // 한 사람당 최대로 받을 선물 개수
        
        Map<String, Integer> friendMap = new HashMap<>(); // 친구별 순서
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String taker = parts[1];
            table[friendMap.get(giver)][friendMap.get(taker)] += 1; // 준 선물 개수 늘리기
        }

        int[] given = Arrays.stream(table).mapToInt(row -> Arrays.stream(row).sum()).toArray(); // 한 사람당 준 선물 총 개수
        int[] taken = new int[friends.length]; // 한 사람당 받은 선물 총 개수
        for (int j = 0; j < friends.length; j++) {
            for (int i = 0; i < friends.length; i++) {
                taken[j] += table[i][j];
            }
        }
        
        int[] ji = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            ji[i] = given[i] - taken[i]; // 선물 지수
        }

        // 준 개수 비교
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (table[i][j] > table[j][i]) { 
                    presents[i]++;
                } else if (table[j][i] > table[i][j]) {
                    presents[j]++;
                } else { // 같을 경우 선물 지수 비교
                    if (ji[i] > ji[j]) {
                        presents[i]++;
                    }
                    if (ji[j] > ji[i]) {
                        presents[j]++;
                    }
                }
            }
        }

        int maxPresents = 0;
        for (int present : presents) {
            maxPresents = Math.max(maxPresents, present);
        }
        return maxPresents;
    }
}
