class Solution {
    public String solution(String s) {
        s = s.toUpperCase();
        String[] words = s.split(" ",-1);
        for(int i=0;i<words.length;i++){
            String[] wordChar = words[i].split("");
            for(int j=1;j<wordChar.length;j+=2){
                wordChar[j] = wordChar[j].toLowerCase();
            }
            words[i] = String.join("",wordChar);
        }
        String answer = String.join(" ",words);
        return answer;
    }
}