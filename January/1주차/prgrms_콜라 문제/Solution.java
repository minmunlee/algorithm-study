class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyBottle = n;
        while(emptyBottle>=a){
            int returnCola = (emptyBottle/a)*b;
            answer += returnCola;
            emptyBottle%=a;
            emptyBottle+=returnCola;
        }
        return answer;
    }
}