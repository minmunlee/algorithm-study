import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[][] arr = new int[N + 1][K + 1];
        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        for(int i = 1; i < N; i++){
            str = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(str.nextToken());
            v[i] = Integer.parseInt(str.nextToken());
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(w[i] > j){   // 현재 무게가 최대 무게를 넘는 경우
                    arr[i][j] = arr[i - 1][j]; // 이전 값 넣음
                }else{
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i]] + v[i]); // 이전 물건과 i번째 물건 중에 더 가치 높은거
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}
