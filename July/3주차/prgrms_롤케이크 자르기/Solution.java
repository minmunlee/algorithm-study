class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        // 각각의 토핑 개수 (인덱스 번호 = 토핑 번호 - 1)
        int[] chul = new int[10000000];
        int[] dong = new int[10000000];
        
        int cTopping = 0; // 철수 토핑 종류 개수
        int dTopping = 0; // 동생 토핑 종류 개수
        
        for(int t : topping){
            if(chul[t - 1] == 0){
                cTopping++;
            }
            
            chul[t - 1]++;    
        }
        
        for(int t : topping){
            chul[t - 1]--;
            dong[t - 1]++;
            
            if(chul[t - 1] == 0){
                cTopping--;
            }
            if(dong[t - 1] == 1){
                dTopping++;
            }
            
            
            if(cTopping == dTopping){
                answer++;
            }
            
            if(cTopping < dTopping){
                break;
            }
        }
        return answer;
    }
}