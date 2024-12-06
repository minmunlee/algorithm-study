import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int t = road[i][2];
            arr[a][b] = Math.min(arr[a][b], t);
            arr[b][a] = Math.min(arr[b][a], t);
        }
        
        int[] d = bfs(N, arr);
        for(int n : d){
            if(n <= K) answer++;
        }

        return answer;
    }
    
    public static int[] bfs(int N, int[][] arr){
        int[] d = new int[N + 1]; // 인덱스와 동일한 노드로 가기 위한 거리 저장
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int n = tmp[0];
            int dis = tmp[1];
            
            for(int i = 1; i <= N; i++){
                if(arr[n][i] != Integer.MAX_VALUE){ // 연결된 노드일 경우
                    int next = dis + arr[n][i]; // 새로운 거리 (기존 경로 + 새 경로)
                    if(next < d[i]){ // 기존 경로보다 짧은 거리일 경우
                        d[i] = next;
                        q.offer(new int[]{i, next});
                    }
                }   
            }
        }
        return d;  
    }
}