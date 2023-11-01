import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] fWord = br.readLine().toCharArray(); // 첫번째로 받은 문자열을 기준으로 함
        
        for(int i = 0; i < N - 1; i++){
            char[] word = br.readLine().toCharArray(); // 이후 문자열을 한줄씩 입력 받음
            for(int j = 0; j < fWord.length; j++){
                if(fWord[j] != word[j]){ // 첫번째 문자열과 다른 문자가 있을 경우 첫번째 문자열의 해당 인덱스 위치 문자열을 변경 
                    fWord[j] = '?';
                }
            
            }
        }

        System.out.println(fWord);

        
    }
    
}
