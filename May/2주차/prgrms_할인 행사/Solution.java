import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 10일 동안의 할인 품목 넣음
        for(int i = 0; i < discount.length; i++) {
            Map<String, Integer> hm = new HashMap<>();
            int cnt = 0; // 날짜 세기
            
            for(int j = i; j < discount.length; j++) {
                if(cnt == 10) { // 10일 지났을 경우
                    break;
                }
                hm.put(discount[j], hm.getOrDefault(discount[j], 0) + 1);
                cnt++;
            }

            boolean check = false;
            for(int j = 0; j < want.length; j++) {
            if(hm.get(want[j]) == null) { // 원하는 물건이 없으면 종료
                check = true;
                break;
                }
            if(number[j] > hm.get(want[j])) { // 물건 수량이 부족할 경우
                    check = true;
                    break;
                }
            }
        
            if(!check) {
                answer++;
            }
            
        }
        return answer;
    }
}