import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        int start = arr[0] * arr[arr.length-1];
        
        for(int i=start; i<2147483647; i++) {
            boolean isGongbeasu = true;
            for(int j=0; j<arr.length; j++) {
                if(i % arr[j] != 0) {
                    isGongbeasu = false;
                    break;
                }
            }
            if(isGongbeasu) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}