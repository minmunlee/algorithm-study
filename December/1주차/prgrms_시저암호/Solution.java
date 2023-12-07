class Solution {
    public String solution(String s, int n) {
        String answer= "";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += " ";
                continue;
            }
            for (int j=1; j<=n; j++) {
                if (c =='z' || c == 'Z')
                    c -= 26;
                c++;
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}