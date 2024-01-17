class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int end = 0;
        for(int i=0;i<section.length;i++){
            if(section[i]>end){
                count++;
                end=section[i]+m-1;
            }
        }
        return count;
    }
}