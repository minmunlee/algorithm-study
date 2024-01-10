class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"}; // 금요일을 1일로 두기 위해 배열 설정
        int sum = 0;
        
        for(int i = 0; i < a - 1; i++){ // 1월부터 a-1월까지의 일 수
            sum+= date[i];
        }
        
        sum += b; // a월 동안 지난 일 수
        
        answer = week[sum % 7]; // 요일 구하기
        
        return answer;
    }
}