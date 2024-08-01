import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> recordMap = new HashMap<>();

        for (String record : records) {
            String[] str = record.split(" ");
            String timeStr = str[0]; // 시간
            String carNumber = str[1]; // 차 번호

            String[] timeArr = timeStr.split(":");
            int hour = Integer.parseInt(timeArr[0]);
            int minute = Integer.parseInt(timeArr[1]);
            int time = hour * 60 + minute;

            recordMap.putIfAbsent(carNumber, new ArrayList<>());
            recordMap.get(carNumber).add(time);
        }

        // 출차 기록이 없을 경우
        for (List<Integer> times : recordMap.values()) {
            if (times.size() % 2 != 0) {
                times.add(23 * 60 + 59);
            }
        }

        // 차량 번호 오름차순
        List<String> cars = new ArrayList<>(recordMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        int index = 0;

        for (String car : cars) {
            List<Integer> times = recordMap.get(car);
            int totalTime = 0;
            for (int i = 0; i < times.size(); i += 2) {
                totalTime += times.get(i + 1) - times.get(i);
            }

            int money = fees[1]; // 기본 요금
            if (totalTime > fees[0]) { // 기본 시간을 초과할 경우
                money += Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            }

            answer[index++] = money;
        }

        return answer;
    }
}