class Solution {
    int count = 0;
    int[] numbers;
    boolean[] check = new boolean[50000];
    public int solution(int[] nums) {
        numbers = nums;
        check();
        dfs(0, 0, 1);
        return count;
    }
    public void check(){
        for(int i=2;i<50000;i++){
            if(!check[i]){
                for(int j=i+i;j<50000;j+=i){
                    check[j] = true;
                }
            }
        }
    }
    public void dfs(int start, int sum, int deep){
        if(deep>3){
            if(!check[sum]) count++;
            return;
        }
        for(int idx=start;idx<numbers.length;idx++){
            dfs(idx+1, sum+numbers[idx], deep+1);
        }
    }
}