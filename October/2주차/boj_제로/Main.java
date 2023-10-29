import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for(int i = 0; i < k; i++){ // k 만큼 stack에 값 입력 받아 저장
            stack.push(Integer.parseInt(br.readLine()));
            if(stack.peek() == 0){ // 0이 들어갈 경우
                stack.pop();
                stack.pop();
            }
        }
        
        int size = stack.size(); // 0으로 인해 정리된 스택의 사이즈
        for(int i= 0; i < size; i++){
            sum += stack.pop();
        }
        System.out.println(sum);

    }
}
