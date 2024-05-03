import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int l = citations.length;
        
        for(int i = 0; i < l; i++){
            int h = l - i; // h회 이상 인용된 논문의 개수. 해당 요소부터 마지막 요소까지의 요소 개수 
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}