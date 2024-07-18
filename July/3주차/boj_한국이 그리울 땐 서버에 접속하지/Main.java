import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] pattern = br.readLine().split("\\*");

        for(int i=0; i<N; i++) {
            String fileName = br.readLine();
            String answer = "NE";
            if(fileName.contains(pattern[0]) && fileName.indexOf(pattern[0]) == 0) { // 첫번째 문자패턴이 포함되어 있으면서 맨 앞자리인지 
                fileName = fileName.substring(fileName.indexOf(pattern[0])+pattern[0].length()); // 문자열에서 첫번째 문자패턴 제거
                // 두번째 문자패턴이 포함되어 있으면서 맨 뒷자리인지
                if(fileName.contains(pattern[1]) && fileName.lastIndexOf(pattern[1])+pattern[1].length() == fileName.length()) {
                    answer = "DA";
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}