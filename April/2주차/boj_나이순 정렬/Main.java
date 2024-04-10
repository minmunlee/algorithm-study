import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder[] lst = new StringBuilder[201];
		for(int i=0;i<lst.length;i++){
		    lst[i] = new StringBuilder("");
		}
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine()," ");
		    int age = Integer.parseInt(st.nextToken());
		    String name = st.nextToken();
		    lst[age].append(age).append(" ").append(name).append("\n");
		}
		StringBuilder sb = new StringBuilder("");
		for(StringBuilder str : lst){
		    sb.append(str);
		}
		System.out.print(sb);
	}
}
