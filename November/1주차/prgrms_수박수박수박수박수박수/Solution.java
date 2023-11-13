class Solution {
    public String solution(int n) {
        String subak = "수박";
        StringBuilder subaks = new StringBuilder("");
        for(int i=0;i<n/2;i++){
            subaks.append(subak);
        }
        if(n%2!=0) subaks.append("수");
        return subaks.toString();
    }
}