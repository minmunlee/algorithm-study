import java.util.*;

// 햄버거 순서: 1 2 3 1

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> ingre = new Stack<>();
        
        for(int i = 0; i< ingredient.length; i++){
            ingre.push(ingredient[i]);
            if(ingre.size() >= 4){
                // 햄버거 순서가 1 2 3 1 일 경우
                if(ingre.get(ingre.size() - 1) == 1 && ingre.get(ingre.size() - 2) == 3 && ingre.get(ingre.size() - 3) == 2 && ingre.get(ingre.size() - 4) == 1){
                    answer++;
                    ingre.pop();
                    ingre.pop();
                    ingre.pop();
                    ingre.pop();
                }
            }
        }
        return answer;
    }
}