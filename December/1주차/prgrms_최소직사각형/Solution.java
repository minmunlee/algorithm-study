import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int[] garo = new int[sizes.length];
        int[] sero = new int[sizes.length];
        for(int i=0;i<sizes.length;i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            if(w>h){
                garo[i] = w;
                sero[i] = h;
            }else{
                garo[i] = h;
                sero[i] = w;
            }
        }
        int garoMax = Arrays.stream(garo).max().getAsInt();
		int seroMax = Arrays.stream(sero).max().getAsInt();
        int answer = garoMax * seroMax;
        return answer;
    }
}