class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            int asc = (int) s.charAt(i);
            if(asc==32){
                answer.append(" ");
                continue;
            }
            int calNum = asc + n;
            int checkNum = (asc>=97)?rowCaseOverCheck(calNum):upCaseOverCheck(calNum);
            answer.append((char)checkNum);
        } 
        return answer.toString();
    }
    public int upCaseOverCheck(int calNum){
        if(calNum>90){
            return 64+(calNum-90);
        }
        return calNum;
    }
    
    public int rowCaseOverCheck(int calNum){
        if(calNum>122){
            return 96+(calNum-122);
        }
        return calNum;
    }
}