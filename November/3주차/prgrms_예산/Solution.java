import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        while(count<d.length){
            budget-=d[count];
            if(budget<0) break;
            count++;
        }
        return count;
    }
}