class Solution {
    public int[] solution(long n) {
        
        String sArray = Long.toString(n); //  long 타입 변수 String 타입으로 변환
        int[] arrNum = new int[sArray.length()]; // String 타입 배열 데이터 저장하는 정수형 배열
        int[] answer = new int[sArray.length()]; // 뒤집힌 데이터 출력하는 배열
        int len = arrNum.length - 1; // 맨 마지막 값
        
        
        for(int i = 0; i < sArray.length(); i++){
            arrNum[i] = sArray.charAt(i) - '0'; // String 타입 문자열을 한글자만 선택해서 char타입으로 변환
        }
        
        while(len != -1){
            for(int i = 0; i < arrNum.length; i++){
                answer[i] =  arrNum[len]; // 맨 마지막 값 넣기
                len--; // pop
            }
        }
        
        
        return answer;
    }
}