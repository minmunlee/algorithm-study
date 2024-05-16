import java.util.*;
class Solution {
    public int[] solution(String s) {
        Set<String> set = new LinkedHashSet<>();

        // 괄호 없애고 값들을 배열에 넣음
        String[] str = s.substring(1,s.length()-1).split("},");
        for(int i = 0;i<str.length;i++){
            str[i] = str[i].replace("{","").replace("}", "");   
        }
        Arrays.sort(str,(a,b)->(a.length() - b.length()));
        
        // 중복 제거
        for(String st : str){
            String[] arr = st.split(",");
            for(String ar : arr){
                set.add(ar);
            }
        }
 
        int[] answer = new int[set.size()];
        int idx = 0;
        for(String d:set){
            answer[idx++] = Integer.parseInt(d);
        }
        
        return answer;
    }
}
