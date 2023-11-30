class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        String three = sb.reverse().toString();
        int answer = Integer.parseInt(three, 3);
        return answer;
    }
}