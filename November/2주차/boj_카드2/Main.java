import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		for(int i=0;i<N;i++){
		    deq.add(i+1);
		}
		while(deq.size()>1){
		    deq.remove();
		    deq.add(deq.remove());
		}
		System.out.print(deq.getFirst());
	}
}
