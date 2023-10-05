class Solution {
    public long solution(long n) {
        double sn = Math.sqrt((double)n);
        return (sn%1>0.0)?-1:(long)Math.pow(sn+1,2);
    }
}