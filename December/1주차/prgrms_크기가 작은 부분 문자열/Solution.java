class Solution {
    public int solution(String t, String p) {
        int size = p.length();
        long num = Long.parseLong(p);
        int count = 0;
        for(int now=size;now<=t.length();now++){
            long subNum = Long.parseLong(t.substring(now-size, now));
            if(subNum<=num) count++;
        }
        int answer = count;
        return answer;
    }
}