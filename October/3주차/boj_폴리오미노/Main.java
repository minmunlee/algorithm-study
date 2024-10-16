import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";
        String[] board = str.split("\\.");

        if(board.length == 0 && !str.contains(".")) { // "." 없는 그냥 문자열이었을 때 확인하기 위해 배열로 만들어줌.
            board = new String[]{str};
        }

        for(int i=0; i<board.length; i++) {
            int len = board[i].length();
            if(len % 2 != 0) { // 홀수면 못바꿈 끝
                result = "-1";
                break;
            }

            int a = len / 2; // 홀수면 "BB"가 무조건 한 번 포함, 짝수면 "AAAA"로 다 가능

            if(a % 2 == 0) {
                board[i] = "AAAA".repeat(a/2);
            }
            else {
                board[i] = "AAAA".repeat(a/2) + "BB";
            }
        }

        if(!result.equals("-1")) {
            result = String.join(".", board);
            result += ".".repeat(str.length() - result.length()); // 맨 뒤에가 "." 이었을 경우 고려
        }

        System.out.print(result);
    }
}