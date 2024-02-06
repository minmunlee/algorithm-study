public class Solution {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int times = 0; // 현재 단어에 대한 누른 키의 총 횟수

            for (char ch : targets[i].toCharArray()) {
                boolean flag = false; // 문자를 찾을 수 있는지 여부
                int time = 101; // 타겟 문자열의 문자 하나당 찾는 횟수

                for (String key : keymap) {
                    if (key.indexOf(ch) != -1) {
                        time = Math.min(key.indexOf(ch) + 1, time);// 문자를 찾은 경우, 해당 문자가 나오는 위치를 통해 누른 키의 횟수를 갱신
                        flag = true;
                    }
                }

                if (!flag) {
                    times = -1;
                    break;
                }

                times += time; // 하나의 문자에 대해 누른 키를 현재까지의 누른 키 총합에 더 함
            }

            answer[i] = times; // 현재 단어에 대한 누른 키 총합을 배열에 저장
        }

        return answer; 
    }
}
