import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(line);

            int n = Integer.parseInt(str.nextToken());
            int[] arr = new int[n];
            int[] m = new int[n - 1]; // 연속된 두 수의 차

            // 길이가 1인 수열
            if(n == 1){
                System.out.println("Jolly");
                continue;
            }

            for(int i  = 0; i < n; i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }

            // 연속된 두 수의 차의 절댓값 저장
            for(int i = 1; i < n; i++){
                m[i - 1] = Math.abs(arr[i - 1] - arr[i]);
            }

            Arrays.sort(m);
            boolean check = true;

            // 정렬한 배열이 연속된 값으로 안들어갔을 경우
            for(int i = 0; i < n - 1; i++){
                if(m[i] != i + 1){
                    check = false;
                    break;
                }
            }

            if(check){
                System.out.println("Jolly");
            }else{
                System.out.println("Not jolly");
            }
        }
    }
}
