class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int front = (a<b)?a:b;
        int back = (front==a)?b:a;
        for(int i=front;i<=back;i++){
            answer+=i;
        }
        return answer;
    }
}