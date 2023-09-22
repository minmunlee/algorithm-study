import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int message = -2;
		    switch(st.nextToken()) {
                case "1":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "2":
                    message = (!stack.isEmpty())?stack.pop():-1;
                    break;
                case "3":
                    message = stack.size();
                    break;
                case "4":
                    message = (stack.isEmpty())?1:0;
                    break;
                case "5":
                    message = (!stack.isEmpty())?stack.peek():-1;
                    break;
            }
            if(message>-2) sb.append(message).append("\n");
		}
		System.out.print(sb);
	}
}