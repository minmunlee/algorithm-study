import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        List<String> nameArray = Arrays.asList(name);
        for(int i=0;i<answer.length;i++){
            String[] photohuman = photo[i];
            int memoryScore = 0;
            for(String human : photohuman){
                int nameIndex = nameArray.indexOf(human);
                if(nameIndex<0) continue;
                memoryScore+=yearning[nameIndex];
            }
            answer[i] = memoryScore;
        }
        return answer;
    }
}