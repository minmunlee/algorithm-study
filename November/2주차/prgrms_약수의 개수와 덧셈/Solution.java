class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            answer+=(i*check(count(i)));
        }
        return answer;
    }

    public int check(int count){
        if(count%2==0) return 1;
        return -1;
    }

    public int count(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num%i==0) count++;
        }
        return count;
    }
}