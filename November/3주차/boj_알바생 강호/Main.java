import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        long sum = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine())); // 받은 돈 넣기
        }

        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

        for(int i = 0; i < N; i++){
            ans.add(list.get(i) - i); // 받은 순위대로 빼기
        }

        for(int i = 0; i < N; i++){
            if(ans.get(i) < 0){ // 음수면 제외
                break;
            }
            sum += ans.get(i);
        }

        System.out.println(sum);
    }
}
