import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int count = 0;
        int zeroCount = 0;
        for(int num : lottos) {
            if(num == 0) zeroCount++; // 0 개수 세기
            else if(list.contains(num)) { // 맞은 번호 개수 세기
                count++;
            }
        }
        // 맞은 개수로 등수 구하기
        if(count > 1) answer[1] = 7 - count; 
        else answer[1] = 6;
        
        // 맞은 개수 + 0 개수 만큼 맞았다고 가정하고 등수 구하기
        if(count + zeroCount > 1) answer[0] = 7 - (count + zeroCount); 
        else answer[0] = 6;
        
        return answer;
    }
}