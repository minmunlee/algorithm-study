import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[] pack = new int[M]; // 패키지 가격 배열
        int[] item = new int[M]; // 개수 가격 배열
        
        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(str.nextToken());
            item[i] = Integer.parseInt(str.nextToken());
        }
        
        int minPa = Arrays.stream(pack).min().getAsInt(); // 패키지 가격 중 가장 싼 값
        int minIt = Arrays.stream(item).min().getAsInt(); // 개별 가격 중 가장 싼 값
        
        if(N >= 6){
            int[] money = new int[2];
            int pa = N / 6; // 필요한 패키지 개수
            int it = N % 6; // 필요한 개별 개수
            money[0] = pa * minPa + it * minIt; // 패키지와 개별 개수 혼합해서 살 경우 가격
            money[1] = Math.min(minPa * (pa + 1), minIt * N); // 패키지만 살 경우와 개별 개수만 살 경우 중 싼 가격
            Arrays.sort(money);
            System.out.println(money[0]);
        }else{
            int money = 0;
            money = Math.min(minPa, minIt * N); // 살 줄이 6개 미만일 경우 패키지는 하나만 필요. 개별 개수는 N만큼 필요
            System.out.println(money);
        }

    }
    
}
