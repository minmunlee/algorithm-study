class Solution {
    String[] list;
    public int solution(String s) {
        list = s.split("");
        int count = 0;
        int subIndex = 0;
        while(subIndex < list.length) {
            subIndex = cutting(subIndex) + 1;
            count++;
        }
        return count;
    }
    
    private int cutting(int startIndex) {
        String x = list[startIndex];
        int xCount = 1;
        int oCount = 0;
        for(int i=startIndex+1;i<list.length;i++) {
            if(list[i].equals(x)) xCount++;
            else oCount++;
            if(xCount == oCount) return i;
        }
        return list.length;
    }
}