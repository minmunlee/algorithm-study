class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int lastIndex1=0, lastIndex2=0, count=0;
        for(int i=0;i<goal.length;i++){
            String goalString = goal[i];
            if(lastIndex1<cards1.length && cards1[lastIndex1].equals(goalString)){
                lastIndex1++;
                count++;
                continue;
            }
            if(lastIndex2<cards2.length && cards2[lastIndex2].equals(goalString)){
                lastIndex2++;
                count++;
                continue;
            }
            break;
        }
        return (count<goal.length)?"No":"Yes";
    }
}