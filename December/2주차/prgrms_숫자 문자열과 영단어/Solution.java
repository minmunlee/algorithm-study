import java.util.HashMap;

class Solution {
    public static int solution(String s) {
        HashMap<Integer, String> map = new HashMap<>() {{
            put(0, "zero");
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
        }};

        for (int i=0; i<map.size(); i++)
            s = s.replace(map.get(i), String.valueOf(i)); //s의 해당 value값을 숫자로 대체

        return Integer.parseInt(s);
    }
}