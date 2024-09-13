import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] rockfes;
    static int[][] store;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int c = 0; c < t; c++) {
            n = Integer.parseInt(br.readLine());
            int[] sanggun = convert(br.readLine().split(" "));
            store = new int[n][2];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                store[i] = convert(br.readLine().split(" "));
            }
            rockfes = convert(br.readLine().split(" "));

            sb.append((bfs(sanggun))?"happy\n":"sad\n");
        }
        System.out.print(sb.toString());
    }

    public static boolean bfs(int[] sanggun) {
        Queue<int[]> que = new LinkedList<>();
        que.add(sanggun);
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (canGo(now, rockfes)) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue; 
                if (canGo(now, store[i])) {
                    que.add(store[i]);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static int[] convert(String[] input) {
        return new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1]) };
    }

    public static boolean canGo(int[] now, int[] target) {
        int distance = Math.abs(target[0] - now[0]) + Math.abs(target[1] - now[1]);
        return distance <= 1000;
    }

}