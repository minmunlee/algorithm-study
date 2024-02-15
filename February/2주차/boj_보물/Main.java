import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        List<Integer> listA = new ArrayList<>(); // A 값 받을 리스트
        List<Integer> listB = new ArrayList<>(); // B 값 받을 리스트
        int sum = 0;

        for(int i = 0; i < N; i++){
            listA.add(Integer.parseInt(str.nextToken()));
        }
        
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            listB.add(Integer.parseInt(str.nextToken()));
        }

        // 가장 작은 값 x 가장 큰 값 으로 구해야 최소 합이 나옴
        Collections.sort(listA); // 오름차순
        Collections.sort(listB, Collections.reverseOrder()); // 내림차순

        for(int i = 0; i < listA.size(); i++){
            sum += listA.get(i) * listB.get(i);
        }

        System.out.println(sum);
    }
    
}
