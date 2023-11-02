import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder nowStr = new StringBuilder(br.readLine());
		for(int i=1;i<N;i++){
		    String nextStr = br.readLine();
		    for(int idx=0;idx<nextStr.length();idx++){
		        if(nowStr.charAt(idx)=='?')continue;
		        if(nowStr.charAt(idx)!=nextStr.charAt(idx)){
		            nowStr.replace(idx,idx+1,"?");
		        }
		    }
		}
		System.out.print(nowStr);
	}
}
