import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1;i<=N;i++){
		    arr.add(i);
		}
		StringBuilder sb = new StringBuilder("");
		int del = 0;
		int count = 0;
		int c = 1;
		while(!arr.isEmpty()){
		    if(count==M){
		        c*=-1;
		        count = 0;
		    }
		    if(c>0){
		        del+=K-1;
		        del%=arr.size();
		    }else{
		        del-=K;
		        if(del<0){
		            while(del<0){
		                del=arr.size()+del;
		            }
		        }
		    }
		    sb.append(arr.remove(del)).append("\n");
		    count++;
		}
		System.out.print(sb);
	}
}