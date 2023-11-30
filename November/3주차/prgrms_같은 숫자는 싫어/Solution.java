import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> stackArray = new ArrayList<>();
        stackArray.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            int beforeNum = stackArray.get(stackArray.size()-1);
            if(arr[i]!=beforeNum) stackArray.add(arr[i]);
        }
        return stackArray.stream().mapToInt(Integer::intValue).toArray();
    }
}