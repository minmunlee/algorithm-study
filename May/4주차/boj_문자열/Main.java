import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine());

    String X = str.nextToken();
    String Y = str.nextToken();
    int n = 50;

    for(int i = 0; i <= Y.length() - X.length(); i++){
      int cnt = 0;
      for(int j = 0; j < X.length(); j++){
        if(X.charAt(j) != Y.charAt(i + j)){
          cnt++;
        }
      }
      n = Math.min(n, cnt);
    }
    System.out.println(n);
  }
}
