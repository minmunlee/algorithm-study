class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int a = Integer.bitCount(n); // 이진수로 변환했을 때의 1의 개수
               
        while(true){
            int i = n + 1;
            int b = Integer.bitCount(i);
            if(a == b){
                return answer = i;
            }
            n++;
        }
    }
}