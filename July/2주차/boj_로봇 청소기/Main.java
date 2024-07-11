import java.io.*;
import java.util.*;

public class Main{
    static int[][] room;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서
    static int N, M, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(r, c, d);
        System.out.print(count);
    }

    public static void dfs(int x, int y, int d) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            count++;
        }

        for(int i=0; i<4; i++) {
            d = (d + 3) % 4;
            int nx = x + direction[d][0];
            int ny = y + direction[d][1];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, d);
                return;
            }
        }

        int back = (d + 2) % 4;
        int bx = x + direction[back][0];
        int by = y + direction[back][1];
        if(bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] == 0) {
            dfs(bx, by, d);
        }
    }
}