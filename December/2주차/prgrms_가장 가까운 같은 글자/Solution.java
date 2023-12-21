import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        ArrayList<String> arr = new ArrayList<>();
        int[] res = new int[s.length()];


        res[0] = -1;
        arr.add(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            if(arr.contains(String.valueOf(s.charAt(i))))
                res[i] = i-arr.lastIndexOf(String.valueOf(s.charAt(i)));
            else
                res[i] = -1;
            arr.add(String.valueOf(s.charAt(i)));
        }
        return res;
    }
}