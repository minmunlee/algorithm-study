class Solution {
    public String solution(int n, int t, int m, int p) {
        // 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        String answer = "";
        
        int num = 0; // 현재 숫자
        int count = 0; // 말한 숫자의 개수
        int position = 0; // 현재 순서

        while (count < t) {
            String str = Integer.toString(num, n);
            for (int i = 0; i < str.length(); i++) {
                if (position % m == p - 1) { // 튜브 차례
                    answer += str.charAt(i);
                    count++;
                    if (count == t) break;
                }
                position++;
            }
            num++;
        }
        
        return answer.toUpperCase();
    }
}