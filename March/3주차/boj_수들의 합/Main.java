import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long S = Long.parseLong(br.readLine());
	    int i = 1, count = 0;
        while(S>0){
            count++;
            i++;
            S-=i;
        }
		System.out.println(count);
	}
}