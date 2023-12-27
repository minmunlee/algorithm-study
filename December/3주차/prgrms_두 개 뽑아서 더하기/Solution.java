import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new ArrayList<Integer>(set).stream().mapToInt(i->i).toArray();
        return answer;
    }
}