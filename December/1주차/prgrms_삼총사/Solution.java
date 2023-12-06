import java.util.*;
class Solution {
    static int count = 0;
    static int[] numbers;
    public int solution(int[] number) {
        numbers = number;
        dfs(0, 0, 1);
        return count;
    }
    public void dfs(int start, int sum, int deep){
        if(deep>3){
            if(sum==0) count++;
            return;
        }
        for(int idx=start;idx<numbers.length;idx++){
            dfs(idx+1, sum+numbers[idx], deep+1);
        }
    }   
}