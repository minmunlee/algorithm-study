import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] points = new int[N][2];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        points[i][0] = Integer.parseInt(input[0]);
	        points[i][1] = Integer.parseInt(input[1]);
	    }
		Arrays.sort(points, new Comparator<int[]>(){
		    public int compare(int[] o1, int[] o2) {
		        return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
		    }
		});
		StringBuilder sb = new StringBuilder("");
		for(int[] arr : points) {
		    sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
		}
		System.out.print(sb);
	}
}