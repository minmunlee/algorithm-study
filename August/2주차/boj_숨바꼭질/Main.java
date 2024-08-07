import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> connected = new HashMap<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());

            // 연결 상태 저장 1 -> [2,3] 2 -> [1,4] 이런 식..
            List<Integer> list1 = connected.getOrDefault(A_i, new ArrayList<>());
            list1.add(B_i);
            connected.put(A_i, list1);
            List<Integer> list2 = connected.getOrDefault(B_i, new ArrayList<>());
            list2.add(A_i);
            connected.put(B_i, list2);
        }

        bfs(connected, N);
    }

    public static void bfs(Map<Integer, List<Integer>> connected, int N) {
        int[] distance = new int[N+1];
        int maxDistance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 출발점

        while(!queue.isEmpty()) {
            int hutgan = queue.poll();

            for(int i : connected.get(hutgan)) { // 연결된 곳 전부 탐색
                if(i == 1) continue; // 출발점이라 제외 (안해주면 distance[1]이 0 이라서 1 헛간으로 회귀한다
                if(distance[i] == 0) { // 첫 방문일 경우 == 최단 거리
                    queue.add(i);
                    distance[i] = distance[hutgan] + 1;
                    maxDistance = distance[i] > maxDistance ? distance[i] : maxDistance;
                }
            }
        }

        int minHutgan = 0;
        int count = 0;
        for(int i=2; i<=N; i++) {
            if(distance[i] == maxDistance) {
                count++;
                if(minHutgan == 0) minHutgan = i;
            }
        }

        System.out.print(minHutgan + " " + maxDistance + " " + count);
    }
}