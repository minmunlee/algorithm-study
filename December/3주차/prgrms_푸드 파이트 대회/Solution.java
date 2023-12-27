class Solution {
    public String solution(int[] food) {
        String answer = "";
        String str1 = "";
        String str2 = "";
        
        for(int i = 1; i < food.length; i++){
            int n = 0;
            int cal = food[i] / 2;
            while(n != cal){
                str1 += String.valueOf(i);
                n++;
            }
        } 

        for(int i = str1.length() - 1; i >= 0; i--){
            str2 += str1.charAt(i);
        }
        
        answer = str1 + '0' + str2;
        
        return answer;
    }
}