class Solution {
    public String solution(String s, int n) {
        String result = "";
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            int ask = (int)arr[i] + n;
            if(arr[i] == ' ') { // 공백일 때
                result += " ";
                continue;
            }
            else if(ask >= 65+n && ask <= 90+n) { // 대문자일 때
                if(ask > 90) {
                    ask = 64 + ask - 90;
                }
            }
            else { // 소문자일 때
                if(ask > 122) {
                    ask = 96 + ask - 122;
                }
            }
            result += (char)ask;
        }
        
        return result;
    }
}