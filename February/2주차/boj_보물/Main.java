import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] A = Arrays.stream(br.readLine().split(" "))
	                    .mapToInt(Integer::parseInt).sorted().toArray();
	    int[] B = Arrays.stream(br.readLine().split(" "))
	                    .mapToInt(Integer::parseInt).sorted().toArray();
	    long S = 0;
	    for(int i=0;i<N;i++){
	        S+= (A[i]*B[N-i-1]);
	    }
	    System.out.print(S);
	}
}