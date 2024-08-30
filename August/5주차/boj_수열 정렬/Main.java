import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(str.nextToken());
            b[i] = a[i];
        }

        Arrays.sort(a);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(a[j] == b[i]){
                  sb.append(j + " ");
                  a[j] = -1;
                  break;
                }
            }
        }

        System.out.print(sb);
    }
}