import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] A = {1,2,3,4,5};
        int[] B = {2,1,2,3,2,4,2,5};
        int[] C = {3,3,1,1,2,2,4,4,5,5};
        int[] count = {0,0,0};
        for(int i=0;i<answers.length;i++){
            if(A[i%A.length]==answers[i]) count[0]++;
            if(B[i%B.length]==answers[i]) count[1]++;
            if(C[i%C.length]==answers[i]) count[2]++;
        }
        String high = "";
        int max = -1;
        for(int i=0;i<3;i++){
            if(count[i]>max){
                high = String.valueOf(i+1);
                max = count[i];
            } 
            else if(count[i]==max) high = high + " " + String.valueOf(i+1);
        }
        int[] answer = Arrays.stream(high.split(" "))
                                .mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}