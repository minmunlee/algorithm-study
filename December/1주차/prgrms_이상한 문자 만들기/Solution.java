class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        String [] str = s.split("");
        for(int i = 0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                answer += str[i];
                count = 0;
                continue;
            }

            if (count % 2 == 0) {
                answer += str[i].toUpperCase();
                count++;
            } else {
                answer += str[i].toLowerCase();
                count++;
            }
        }
        return answer;
    }
}