import java.util.*;

public class Solution {
    static List<String> com;

    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> hm = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String order : orders) {
            char[] menu = order.toCharArray();
            Arrays.sort(menu); 
            String sortedOrder = new String(menu);

            for (int c : course) {
                com = new ArrayList<>();
                dfs(sortedOrder, c, 0, "", new boolean[sortedOrder.length()]); // 조합 구하기
                for (String comb : com) {
                    hm.put(comb, hm.getOrDefault(comb, 0) + 1); // 조합 빈도수 구하기
                }
            }
        }

        for (int c : course) {
            int maxFrequency = 0;

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() >= 2) {
                    maxFrequency = Math.max(maxFrequency, entry.getValue()); // 최대 빈도 구하기
                }
            }

            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() == maxFrequency) { // 최대 빈도를 가진 조합 추가
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    static void dfs(String order, int length, int start, String current, boolean[] visited) {
        if (current.length() == length) {
            com.add(current);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(order, length, i + 1, current + order.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}