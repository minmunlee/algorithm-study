class Solution {
    public int solution(String s) {
        int answer = 1;
        int first_word_cnt = 1; // 첫번째 문자 개수
        int other_word_cnt = 0; // 다른 문자 개수
        int fIdx = 0; // 첫번째 문자 위치
        int lIdx = 1; // 다른 문자 위치
        
        while(lIdx < s.length()){
            if(first_word_cnt == other_word_cnt){ // 첫번째 문자 개수와 다른 문자 개수 같을 경우
                fIdx = lIdx;
                lIdx += 1;
                first_word_cnt = 1;
                other_word_cnt = 0;
                answer++;
            }else{
                if(s.charAt(fIdx) == s.charAt(lIdx)){ // 첫번째 문자와 다른 위치의 문자가 같을 경우
                    first_word_cnt += 1;
                }else{
                    other_word_cnt += 1;
                }
                lIdx++;
            }   
        }
               
        return answer;
    }
}