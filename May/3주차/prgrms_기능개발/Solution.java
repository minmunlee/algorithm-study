import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < progresses.length; i++){
            int n = 100 - progresses[i]; // 남은 진도
            
            if(n % speeds[i] != 0){
                n = n / speeds[i] + 1;
            }else{
                n /= speeds[i];
            }
            queue.offer(n); // 완료까지 남은 일 수
        }
        
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        int start = queue.poll();
        
        while(!queue.isEmpty()){
            
            int now = queue.peek();
        
            if(start < now){
                list.add(cnt);
                cnt = 1;
                start = now;
                queue.poll();
                
            }else{
                cnt++;
                queue.poll();
            }
            
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}