class Solution {
    public int solution(int[][] sizes) {
        int colMax = 0, lowMax = 0;
        
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(colMax < sizes[i][0]) colMax = sizes[i][0];
            if(lowMax < sizes[i][1]) lowMax = sizes[i][1];
        }
        
        return colMax * lowMax;
    }
}