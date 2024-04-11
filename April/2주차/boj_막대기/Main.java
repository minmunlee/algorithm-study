import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int stick = 64;
        int cnt = 0;
                
        while (true){
            // 막대의 길이가 X보다 큰 경우
            if(stick > X){
                stick /= 2;
            }else{
                // 남은 길이 계산
                X -= stick;
                cnt++;
            }

            if(X == 0){
                System.out.println(cnt);
                break;
            }
        }   
    }
}
