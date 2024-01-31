public class Solution {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int times = 0; // 현재 단어에 대한 누른 키의 총 횟수를 초기화

            for (char ch : targets[i].toCharArray()) {
                boolean flag = false; // 문자를 찾을 수 있는지 여부
                int time = 101; // keymap의 원소의 길이가 최대 100이기 때문에 101로 초기화

                // keymap에 있는 모든 원소를 반복하면서 가장 적게 누를 수 있는 char를 찾음
                for (String key : keymap) {
                    if (key.indexOf(ch) != -1) { // key안에 char가 존재하면
                        time = Math.min(key.indexOf(ch) + 1, time);// 현재 문자를 찾은 경우, 해당 문자가 나오는 위치를 통해 누른 키의 횟수를 갱신
                        flag = true; // 문자를 찾을 수 있음을 표시
                    }
                }

                // 문자를 찾지 못한 경우
                if (!flag) {
                    times = -1; // 현재 단어에 대한 누른 키를 계산할 수 없음을 나타냄
                    break;
                }

                times += time; // 하나의 문자에 대해 누른 키를 현재까지의 누른 키 총합에 더 함
            }

            answer[i] = times; // 현재 단어에 대한 누른 키 총합을 배열에 저장
        }

        return answer; 
    }
}
