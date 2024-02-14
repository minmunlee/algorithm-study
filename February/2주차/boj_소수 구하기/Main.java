import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                for (int j = i + i; j <= N && j > 1; j += i) {
                    arr[j] = 1;
                }
            }
        }
        for (int i = M; i <= N; i++)
            if (arr[i] == 0)
                System.out.println(i);
    }
}