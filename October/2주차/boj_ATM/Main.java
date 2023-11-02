import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
		            .mapToInt(Integer::parseInt).sorted().toArray();
		int temp = 0;
		for(int i=0;i<arr.length;i++){
		    temp=temp+arr[i];
		    arr[i]=temp;
		}
		int sum = 0;
		for(int p : arr){
		    sum+=p;
		}
		System.out.print(sum);
	}
}