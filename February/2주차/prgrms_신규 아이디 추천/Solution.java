class Solution {
    public String solution(String new_id) {
        new_id = StepOne(new_id);
        new_id = Steptwo(new_id);
        new_id = StepThree(new_id);
        new_id = StepFour(new_id);
        new_id = StepFive(new_id);
        new_id = StepSix(new_id);
        new_id = StepSeven(new_id);
        return new_id;
    }
    //1단계: 대문자를 소문자로 치환
    private String StepOne(String id) {
        return id.toLowerCase();
    }
    //2단계: 문자를 제거
    private String Steptwo(String id) {
        return id = id.replaceAll("[^a-z0-9-_.]", "");
    }
    //3단계: 하나의 마침표(.)로 치환
    private String StepThree(String id) {
        return id.replaceAll("\\.{2,}", ".");
    }
    //4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
    private String StepFour(String id) {
        if(id.length() < 1) return id;
        if(id.charAt(0)=='.') id = id.replaceFirst(".", "");
        if(id.length() < 1) return id;
        if(id.charAt(id.length()-1)=='.') id = id.replaceFirst(".$", "");
        return id;
    }
    //5단계: 빈 문자열이라면, new_id에 "a"를 대입
    private String StepFive(String id) {
        if(id.length() < 1) return "a";
        return id;
    }
    //6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외 나머지 문자들 제거
    private String StepSix(String id) {
        if(id.length()>=16) id = id.substring(0,15);
        if(id.charAt(id.length()-1)=='.') id = id.substring(0, id.length()-1);
        return id;
    }
    //7단계: 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복
    private String StepSeven(String id) {
        if(id.length()<3) return StepSeven_sub(id);
        return id;
    }
    //길이늘리기
    private String StepSeven_sub(String id) {
        StringBuilder sb = new StringBuilder(id);
        String last = id.substring(id.length()-1,id.length());
        for(int i=id.length();i<3;i++) {
            sb.append(last);
        }
        return sb.toString();
    }
}