import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(1 <= N && N < 100){ // 2자리 수는 다 순열
             System.out.println(N);
        }else{
            int num = 99; // 두자리 수 까지는 더해진 값
            for(int i = 100; i <= N; i++){
                int hun = i / 100; // 100자리
                int ten = i % 100 / 10; // 10자리
                int one = i % 100 % 10; // 1자리
                int diff = hun - ten;
                int diff2 = ten - one;

                if(diff == diff2){
                    num++;
                }
            }

            System.out.println(num);
        }
    }
}
