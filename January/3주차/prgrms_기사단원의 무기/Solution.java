class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 1;
        int[] yackcount = new int[number+1];
        for(int i=2;i<=number;i++){
            yackcount[i]++;
            for(int j=i;j<=number;j+=i){
                yackcount[j]++;
            }
            sum+=(yackcount[i]>limit)?power:yackcount[i];
        }
        return sum;
    }
}