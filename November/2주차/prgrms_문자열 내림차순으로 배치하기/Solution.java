import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] word = s.split("");
        Arrays.sort(word,Collections.reverseOrder());
        StringBuilder answer = new StringBuilder("");
        for(String w : word){
            answer.append(w);
        }
        return answer.toString();
    }
}