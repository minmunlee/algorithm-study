class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int carpet = brown + yellow; // 카펫의 크기
        
        int row = 0;
        int col = 0;
        
        for(int i = 1; i <= carpet; i++){
            row = i;
            col = carpet / row;
            
            if(row > col){ // 열이 행보다 길 경우
                continue;
            }
            
            if((row - 2) * (col - 2) == yellow){ // 노란 격자는 전체 카펫 행과 열에서 각각 2씩 뺀 행과 열의 길이와 같다
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }
}