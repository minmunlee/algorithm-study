import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    br.readLine();
	    int A[] = Arrays.stream(br.readLine().split(" "))
	                .mapToInt(Integer::parseInt).sorted().toArray();
		br.readLine();
		int num[] = Arrays.stream(br.readLine().split(" "))
		            .mapToInt(Integer::parseInt).toArray();
		for(int i : num){
		    System.out.println(find(A,i));
		}
	}
	static int find(int A[],int a){
	    int bottom = 0; int top = A.length-1; int mid;
	    while(bottom<=top){
	        mid = (bottom+top)/2;
	        if(A[mid]>a){
	            top = mid-1;
	        }
	        else if(A[mid]<a){
	            bottom = mid+1;
	        }
	        else if(A[mid]==a){
	            return 1;
	        }
	    }
	    return 0;
	}
}