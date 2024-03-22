import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int w;
    public static int h;
    public static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] visit; // 방문한적 있는지 확인

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            w = Integer.parseInt(str.nextToken());
            h = Integer.parseInt(str.nextToken());
            visit = new boolean[h][w];
            int cnt = 0;

            if(w == 0 && h == 0){
                break;
            }

            map = new int[h][w];

            for(int i = 0; i < h; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1 && !visit[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        
    }

    public static void dfs(int i, int j){

        visit[i][j] = true;

        for(int k = 0; k < 8; k++){
            // 땅 위 아래 옆 대각선 체크
            int x = i + dx[k];
            int y = j + dy[k];

            if(x >= 0 && y >= 0 && x < h && y < w){ // 맵 밖으로 안나가는 조건
                if(map[x][y] == 1 && !visit[x][y]){ // 땅이면서 방문한 적 없는 조건
                    dfs(x, y);
                }
            }
             
        }

    }
}
