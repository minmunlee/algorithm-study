class Solution {
    public int solution(int n) {
        int count = 0;
        boolean[] notsosu = new boolean[n+1];
        notsosu[1]=true;
        for(int i=2;i<=n;i++){
            if(notsosu[i]==false){
                count++;
                for(int j=i;j<=n;j=j+i){
                    notsosu[j]=true;
                }
            }
        }
        return count;
    }
}