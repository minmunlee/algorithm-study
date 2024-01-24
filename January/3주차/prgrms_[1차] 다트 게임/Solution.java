class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] str = dartResult.split("");
        int num[] = new int[3]; // 기회마다 얻는 점수
        int idx = -1; // num 배열 인덱스

        for (int i = 0; i < str.length; i++) {
            // 숫자일 경우
            try {
                int isNum = Integer.parseInt(str[i]);
                if (isNum == 1 && str[i + 1].equals("0")) { // 10일 경우
                    isNum = 10;
                    i++;
                }
                idx++;
                num[idx] = isNum;
            } catch (NumberFormatException ex) {        // 문자일 경우
                if (str[i].equals("D")) {
                    num[idx] = (int) Math.pow(num[idx], 2);
                } else if (str[i].equals("T")) {
                    num[idx] = (int) Math.pow(num[idx], 3);
                } else if (str[i].equals("*")) {
                    num[idx] *= 2;
                    if (idx - 1 != -1) {        // 스타상이 첫번째에 나온게 아닐 경우
                        num[idx - 1] *= 2;
                    }
                } else if (str[i].equals("#")) {
                    num[idx] *= -1;
                }
            }
        }

        for (int n : num) {
            answer += n;
        }
        return answer;
    }
}
