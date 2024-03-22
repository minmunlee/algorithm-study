import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        
        for(String str : s.split("")){
            if(stack.isEmpty()){
                stack.push(str);
                continue;
            }
            
            if(!stack.isEmpty()){
                if(stack.peek().equals(str)){ // 같은 알파벳이 붙어 있을 경우
                    stack.pop();
                }else{
                    stack.push(str);
                }
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}