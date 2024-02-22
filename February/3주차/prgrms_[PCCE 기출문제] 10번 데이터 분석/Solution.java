import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> cutting = new ArrayList();
        int cutting_idx = collectIdx(ext);
        
        for(int i=0; i<data.length; i++) {
            if(data[i][cutting_idx] >= val_ext) continue;
            cutting.add(data[i]);
        }
        
        int sort_idx = collectIdx(sort_by);
        sortList(cutting, sort_idx);
        
        return cutting.stream()
            .toArray(int[][]::new); 
    }
    
    public int collectIdx(String word) {
        switch(word) {
            case "code" :
                return 0;
            case "date" :
                return 1;
            case "maximum" :
                return 2;
            case "remain" :
                return 3;
        }
        return 0;
    }
    
    public void sortList(List<int[]> list, final int sort_idx) {
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[sort_idx] < o2[sort_idx]){
                	return -1;
                }
                if(o1[sort_idx] > o2[sort_idx]){
                    return 1;
                }
                return 0;
            }
        });
    }
}