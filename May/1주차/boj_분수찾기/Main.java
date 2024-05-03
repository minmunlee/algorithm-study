import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int depth = 0;

        while(X - depth > 0){
            X -= depth; // 몇번째인지
            depth++;
        }

        int sum = depth + 1; // 분자 분모 합
        int bunmo = 0;
        int bunja = 0;

        // 짝수: 분자가 커지고 분모가 작아짐
        if(depth % 2 == 0){
            bunmo = sum - X;
            bunja = X;
        }else{
            // 홀수: 분모가 커기고 분자가 작아짐
            bunmo = X;
            bunja = sum - X;
        }

        System.out.println(bunja + "/" + bunmo);
    }
  
}
