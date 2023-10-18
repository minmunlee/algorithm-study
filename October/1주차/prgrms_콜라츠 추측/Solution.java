class Solution {
    public int solution(int num) {
        int count = 1;
        if(num==1) return 0;
        long n = num;
        while(count<=500){
            if(n%2==0) n/=2;
            else n = (n*3)+1;
            if(n==1) break;
            count++;
        }
        return (count>500)?-1:count;
    }
}