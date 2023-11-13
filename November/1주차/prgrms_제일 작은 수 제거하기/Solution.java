import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        int[] answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        int i=0;
        int arrcount = 0;
        while(i<answer.length){
            if(arr[arrcount]==min){
                arrcount++;
                continue;
            }
            answer[i] = arr[arrcount];
            arrcount++;
            i++;
        }
        return answer;
    }
}
