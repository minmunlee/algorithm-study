import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Long> stack = new Stack<>();
		for(int i=0;i<K;i++){
		    long num = Long.parseLong(br.readLine());
		    if(num==0) stack.pop();
		    else stack.push(num);
		}
		long sum = 0;
		while(!stack.empty()){
		    sum+=stack.pop();
		}
		System.out.print(sum);
	}
}