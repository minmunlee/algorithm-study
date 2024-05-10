import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (true) {
            if (A == K) {
                System.out.println(cnt);
                break;
            }
            if (K % 2 == 0 && K >= A * 2) { // 2로 나누어 떨어질 경우
               K = K / 2;
            } else {
               K--;
            }
            cnt++;
        }
    }
}
