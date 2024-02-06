class Solution {
    boolean[] lostClothes;
    boolean[] reserveClothes;
    public int solution(int n, int[] lost, int[] reserve) {
        lostClothes = new boolean[n];
        lostClothesCheck(lost);
        reserveClothes = new boolean[n];
        reserveClothesCheck(reserve);
        for(int i=0;i<n;i++){
            if(!reserveClothes[i]) continue;
            if(i>0 && lostClothes[i-1]) {
                lostClothes[i-1] = false;
                continue;
            }
            if(i < n - 1 && lostClothes[i+1]) lostClothes[i+1] = false;
        }
        int answer = n;
        for(boolean l : lostClothes) {
            if(l) answer--;
        }
        return answer;
    }
    
    private void lostClothesCheck(int[] lost) {
        for(int l : lost) {
            lostClothes[l-1] = true;
        }
    }
    private void reserveClothesCheck(int[] reserve) {
        for(int r : reserve) {
            if(lostClothes[r-1]) {
                lostClothes[r-1] = false;
                continue;
            }
            reserveClothes[r-1] = true;
        }
    }
}