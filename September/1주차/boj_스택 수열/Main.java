import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder("");
		int count = 1;
		for(int i=0;i<n;i++){
		    int num = Integer.parseInt(br.readLine());
            if(num>=count){
                while(count<=num){
                    stack.add(count++);
                    sb.append("+").append("\n");
                }
            }
            if(stack.peek()!=num){
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append("-").append("\n");
		}
		System.out.print(sb);
	}
}