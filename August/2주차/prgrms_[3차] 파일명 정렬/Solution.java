import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                // head 부분만 자름
                String s1 = o1.split("[0-9]")[0];
                String s2 = o2.split("[0-9]")[0];
                
                int sameStr = s1.toLowerCase().compareTo(s2.toLowerCase());
                if(sameStr == 0) { // head부분이 같을 경우
                    int num1 = convertNum(o1.substring(s1.length())); // number + tail
                    int num2 = convertNum(o2.substring(s2.length()));
                    sameStr = num1 - num2;
                }
                return sameStr;
            }
        });
        return files;
    }
    
    private int convertNum(String str) {
        String num = "";
        
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                num += c;
            } else {
                break;
            }
        }

        return Integer.parseInt(num);
    }
}