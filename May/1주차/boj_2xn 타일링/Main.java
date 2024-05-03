import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long sq[] = new long[n+2];
		sq[0]=0;sq[1]=1;sq[2]=2;
		for(int i=3;i<=n;i++){
		    sq[i]=(sq[i-1]+sq[i-2])%10007;
		}
		System.out.print(sq[n]);
	}
}