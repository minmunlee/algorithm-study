import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0) ans.add(arr[i]);
        }
        if(ans.size()==0) return new int[]{-1};
        return ans.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
