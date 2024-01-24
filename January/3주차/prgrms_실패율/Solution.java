
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] probability = new double[N]; // 실패율
        
        int len = stages.length; // 스테이지에 도달한 플레이어 수
        
        for(int i = 1; i <= N; i++){ // 스테이지 1부터 N 까지 각각 비교
            int nPlayers = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i){
                    nPlayers++;
                }
            }
            if(len == 0) {
                probability[i - 1] = 0.0;
            } else {
                probability[i - 1] = (double) nPlayers / len;
            }
            len -= nPlayers; // 각 스테이지별 인원수 빼기
        }
        
        // 실패율 가장 높은 순으로 정렬
        for(int i = 0; i < N; i++) {
            int idx = 0; // 최대값이 포함된 인덱스 위치
            double max = -1.0;
            for(int j = 0; j < N; j++){
                if(max < probability[j]){
                    max = probability[j];
                    idx = j + 1;
                }
            }
            probability[idx - 1] = -1.0; // 구한 최대값은 -1.0으로 바꿈
            answer[i] = idx;
        }        
        return answer;
    }
}
