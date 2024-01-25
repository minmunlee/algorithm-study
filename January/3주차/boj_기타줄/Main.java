import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String imsi[] = br.readLine().split(" ");
		int lst[] = Arrays.stream(imsi).mapToInt(Integer::parseInt).toArray();
		String min2[] = br.readLine().split(" ");
		int min[] = Arrays.stream(min2).mapToInt(Integer::parseInt).toArray();
		for(int i=1;i<lst[1];i++){
		    String tmp2[] = br.readLine().split(" ");
		    int tmp[] = Arrays.stream(tmp2).mapToInt(Integer::parseInt).toArray();
		    if(tmp[0]<min[0])
		        min[0]=tmp[0];
		    if(tmp[1]<min[1])
		        min[1]=tmp[1];
		}
		int count = 0;    
		count = Math.min(((lst[0]/6) + 1) * min[0], Math.min(lst[0] * min[1], ((lst[0]/6) * min[0]) + ((lst[0]%6) * min[1])));
		System.out.print(count);
	}
}