import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    HashMap<String, Integer> bookCount = new HashMap<>();
	    int N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++) {
	        String book = br.readLine();
	        bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
	    }
	    String bestBook = "";
	    int maxCount = 0;
	    for(Map.Entry<String, Integer> entry : bookCount.entrySet()) {
	        if(entry.getValue() < maxCount) continue;
	        if(entry.getValue() == maxCount && entry.getKey().compareTo(bestBook) > 0) {
	            continue;
	        }
	        bestBook = entry.getKey();
	        maxCount = entry.getValue();
	    }
	    System.out.print(bestBook);
	}
}
