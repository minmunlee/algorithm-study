class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1]; // 메모리 초과 문제 해결
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = Math.max((int)((i + left) / n) + 1, (int)((i + left) % n) + 1);
        }

        return answer;
    }
}