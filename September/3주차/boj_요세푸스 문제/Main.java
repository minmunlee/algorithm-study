import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1;i<=N;i++){
		    arr.add(i);
		}
		StringBuilder sb = new StringBuilder("<");
		int del = K-1;
		for(int i=0;i<N-1;i++){
		    sb.append(arr.remove(del)).append(", ");
		    del+=K-1;
		    del%=arr.size();
		}
		sb.append(arr.get(0)).append(">");
		System.out.print(sb);
	}
}