import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];

        str = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(str.nextToken());
        int c = Integer.parseInt(str.nextToken());
        int d = Integer.parseInt(str.nextToken());

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        clean(r, c, d);
    }

    public static void clean(int r, int c, int d){
        int cnt = 0;
        boolean[][] isClean = new boolean[N][M]; // 청소가 되어 있는지
        boolean ongoing = false;

        while(!ongoing){
            boolean moveCheck = false; // 이동했는지 체크

            if(!isClean[r][c]){
                isClean[r][c] = true;
                cnt++;
            }

            for(int i = 0; i < 4; i++){
                d = (d + 3) % 4; // 현위치에서 왼쪽 방향으로 회전
                int x = r + dx[d];
                int y = c + dy[d];

                // 유효 범위 내에 있고 빈 칸이고 청소가 안되어 있는 경우
                if(x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 0 && !isClean[x][y]){
                    r = x;
                    c = y;
                    moveCheck = true;
                    break;
                }
            }

            if(!moveCheck){
                int goBack = (d + 2) % 4; // 후진
                r += dx[goBack];
                c += dy[goBack];

                if(r < 0 || r >= N || c < 0 || c >= M || arr[r][c] == 1){ // 후진이 불가 할 경우
                    ongoing = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
