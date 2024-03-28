import java.util.*;
// 메모리 초과
public class Solution {
    int[] map;
    boolean[] visited;
    public int solution(int n) {
        map = new int[n+1];
        visited = new boolean[n+1];
        bfs(0,0,n);
        return map[n];
    }
    public void bfs(int start, int battery, int n) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start, battery});
        while(!que.isEmpty()) {
            int[] now = que.poll();
            int loc = now[0];
            int b = now[1];
            if(visited[loc] && map[loc]<=b) continue;
            map[loc] = b;
            if(loc < n) {
                que.add(new int[]{loc+1,map[loc]+1});
            }
            if(loc <= n/2) {
                que.add(new int[]{loc*2,map[loc]});
            }
            visited[loc] = true;
        }
    }
}