import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<Integer>();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            answer.add(stack.search(c)); // search: 같은 문자열중 가장 가까운 위치 반환
            stack.push(c);
            
        }
        
        
        return answer;
    }
}