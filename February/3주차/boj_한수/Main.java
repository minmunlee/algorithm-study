import java.io.*;
import java.util.Arrays;
public class Main{
    static int cnt=99;
	public static void main(String[] args)throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    if(N<100){
	        cnt=N;
	    }else{
	        for(int i=100;i<N+1;i++){
	            count(Integer.toString(i));
	        }
	    }
	    System.out.print(cnt);
	}
	static void count(String x){
	    int[] num = Arrays.stream(x.split(""))
	                .mapToInt(Integer::parseInt).toArray();
	    int[] arr = new int[num.length-1];
	    for(int i=0;i<arr.length;i++){
	        arr[i]=num[i+1]-num[i];
	    }
	    if(arr[0]==arr[1]){
	        if(arr.length>2){
	            if(arr[0]==arr[3])
	                cnt+=1;
	        }else{
	            cnt+=1;
	        }
	    }
	}
}