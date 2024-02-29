class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 시작 점 위치 (wallpaper의 길이는 50 이하)
        int lux = 50;
        int luy = 50;
        // 드래그 끝 점 위치
        int rdx = 0;
        int rdy = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){ // 파일이 있는 경우
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;
        
        
        return answer;
    }
}