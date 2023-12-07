public class Solution {
    public static int solution(String t, String p) {
        int result = 0;
        for (int i=0; i<t.length()-p.length()+1; i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p))
                result++;
        }

        return result;
    }
}
