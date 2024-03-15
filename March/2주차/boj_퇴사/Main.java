import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str;
        int[] T = new int[N]; // 일을 끝내는 데 걸리는 시간
        int[] P = new int[N]; // 일을 끝내면 받는 금액
        int[] dp = new int[N + 1]; // 최대 받는 금액

        dp[N] = 0;

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(str.nextToken());
            P[i] = Integer.parseInt(str.nextToken());
        }
        
        for(int i = N - 1; i >= 0; i--){
            int tmp = P[i] + dp[i + T[i]]; // 오늘 상담일을 해서 번 돈 + 상담일 마친 날 기준 가장 많이 벌 수 있는 돈
            
            if(i + T[i] > N || tmp < dp[i + 1]){
                // 못할 때 OR 안할 때
                dp[i] = dp[i + 1];
            }else{
                dp[i] = tmp;
            }
        }

        System.out.println(dp[0]);
    }
    
}
