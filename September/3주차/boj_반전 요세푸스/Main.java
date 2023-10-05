import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken()); // 입력 받을 데이터 개수
        int K = Integer.parseInt(str.nextToken()); // 제거할 데이터 순서
        int M = Integer.parseInt(str.nextToken()); // 반전되는 주기
        int count = 1;
        int num = 0;

       Deque<Integer> deque = new ArrayDeque<>();

       for(int i = 1; i <= N; i++){
            deque.add(i);
       }

       while(!deque.isEmpty()){
            if(count != K){
                deque.add(deque.poll());
                count++;
            }else{
                count = 1;
                System.out.println(deque.poll());
                num++;  
            }
            if(num == M){
                if(count != K){
                     deque.addLast(deque.pollLast());
                     count++;
                }else{
                    count = 1;
                    System.out.println(deque.pollLast());
                }
            }
       }
    }
}
