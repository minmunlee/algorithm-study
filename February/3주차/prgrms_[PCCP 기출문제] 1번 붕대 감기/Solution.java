class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int nowHealth = health; // 현재 체력
        int lastTime = attacks[attacks.length - 1][0]; // 마지막 공격 시간
        int attIdx = 0; // attack 배열 관련 index
        int bonus = 0; // 추가 회복량 받는 시간
        
        for(int i = 1; i <= lastTime; i++){ // 1초부터 마지막 공격 시간까지
            if(i == attacks[attIdx][0]){ // 공격 시간인 경우
                nowHealth -= attacks[attIdx][1];
                attIdx++;
                bonus = 0; // 추가 회복량 시간 초기화
                if(nowHealth <= 0){
                    answer = -1;
                    return answer;
                }
            }else{
                if(nowHealth < health){
                    nowHealth += bandage[1];
                    bonus++;
                    if(bandage[0] == bonus){ // 추가 회복 시간까지 쌓인 경우
                        nowHealth += bandage[2];
                        bonus = 0;
                    }
                    if(nowHealth > health){
                        nowHealth = health;
                    }
                }
            }
        }
        
        answer = nowHealth;
        return answer;
    }
}