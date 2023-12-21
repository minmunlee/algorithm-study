import java.util.Arrays;

class Solution {
    public static String[] solution(String[] str, int n) {
        String temp;

        for (int i=0; i<str.length-1; i++) {
            for (int j=i+1; j<str.length; j++) {
                if (str[i].charAt(n)>str[j].charAt(n) || (str[i].charAt(n)==str[j].charAt(n) && str[i].compareTo(str[j])>0)) {
                    temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }

        return str;
    }
}