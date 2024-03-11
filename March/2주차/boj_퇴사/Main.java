import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for(int i=0; i<N; i++) {
            String[] temp = br.readLine().split(" ");
            T[i] = Integer.parseInt(temp[0]);
            P[i] = Integer.parseInt(temp[1]);
        }

        int[] money = new int[N+1];
        dp(money);
        System.out.print(money[N]);
    }

    static void dp(int[] money) {
        for(int i=0; i<N; i++) {
            int nextDay = i + T[i]; // 다음 날짜

            if(nextDay <= N) { // 다음 날짜가 기한을 넘어가지 않을 때
                // 다음 날짜로 가는 경우의 수 중 금액이 가장 높은 것으로 가기 위해 비교
                // 처음이면 지금 이 값으로 가고, 처음이 아니면 이미 있는값과 지금 값을 비교해서 큰걸로 감
                if(money[nextDay] < money[i] + P[i]) {
                    money[nextDay] = money[i] + P[i];
                }
            }

            // 내일(바로다음날)에 지금 금액 그대로 넣어줌
            // -> 지금 일자의 상담을 안할 경우를 생각하기 위함
            if(money[i+1] < money[i]) money[i+1] = money[i];
        }
    }
}