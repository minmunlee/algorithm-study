import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String document = br.readLine();
	    String word = br.readLine();
		System.out.print((document.length() - document.replace(word, "").length())/word.length());
	}
}