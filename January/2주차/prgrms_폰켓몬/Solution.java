import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int max = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int answer = (set.size()>max)?max:set.size();
        return answer;
    }
}