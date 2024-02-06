import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String solution(String s, String skip, int index) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = getSkipList(arr[i], index, skip);
        }

        return new String(arr);
    }

    public static Character getSkipList(char c, int index, String skip) {

        List<Character> charList = new ArrayList<>();

        for (char letter = 'a'; letter <= 'z'; letter++)
            charList.add(letter);

        for (int i = 0; i < skip.length(); i++)
            charList.remove(Character.valueOf(skip.charAt(i)));

        return charList.get((charList.indexOf(c) + index) % charList.size());
    }
}