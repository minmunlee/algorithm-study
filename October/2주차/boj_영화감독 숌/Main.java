import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 665; // 종말의 수를 찾기 시작할 값. 초기값
        String s = "";

        for(int i = 0; i < N; i++){ // 0부터 N-1 까지 영화 제목 생성 반복문
            while(true){ // 종말의 수를 찾는 루프
                n++;
                s = Integer.toString(n);
                if(s.contains("666")){
                    break;
                }
            }
        }

        System.out.println(n);
    }
}
