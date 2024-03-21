class Solution {
    public int solution(int n) {
        int answer = 0;
        String two_n = Integer.toBinaryString(n);
        int count_n = 0;
        for(int i=0; i<two_n.length(); i++){
            if(two_n.charAt(i) == '1') count_n++;
        }
        
        for(int i=n+1; i<=1000000; i++){
            String two_i = Integer.toBinaryString(i);
            int count_i = 0;
            for(int k=0; k<two_i.length(); k++){
                if(two_i.charAt(k) == '1') count_i++;
            }
            if(count_n == count_i){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}