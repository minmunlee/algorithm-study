class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int re = 0; // 받은 개수
        
        while(n >= a){
            re = n / a * b;
            answer += re;
            n = re + n % a;
        }
        return answer;
    }
}