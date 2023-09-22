import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] susick = br.readLine().split("");
		String cal = "+-*/";
		Stack<Long> stack = new Stack<>();
		for(String s : susick){
		    if(cal.contains(s)){
		        long a = stack.pop();
		        long b = stack.pop();
		        switch(s){
		            case "+": stack.add(b+a);
		            break;
		            case "-": stack.add(b-a);
		            break;
		            case "*": stack.add(b*a);
		            break;
		            case "/": stack.add(b/a);
		            break;
		        }
		    }else{
		        stack.add(Long.parseLong(s));
		    }
		}
		System.out.print(stack.pop());
	}
}