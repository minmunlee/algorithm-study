import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 6616. 문자열 암호화
 * 복호화를 할 때 암호화된 문장에서 첫 번째 글자를 가져옵니다. 그리고 N만큼 떨어진 거리에 있는 문자들을 가져옵니다.
 * (그 사이에 있는 N - 1개의 문자들은 건너뜀) 이를 계속 반복하게 되면 결국엔 문자열 끝에 다다르게 됩니다.
 * 문자열 끝에 다다르면 다시 이번에는 두 번째 위치의 문자로 되돌아가 위에서 설명한 것과 같은 과정을 반복합니다.
 * 알고리즘은 사용자가 입력한 평문에서 모든 영문자를 사용하게 되면 끝나게 됩니다.
 *
 * 입력 예
 * 2
 * CTU Open Programming Contest
 * 7
 * This is a secret message that noone should ever see Lets encrypt it
 * 15
 * text too short
 * 0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        List<String> lst;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            lst = Arrays.stream(br.readLine().replace(" ", "").split("")).collect(Collectors.toList());
            System.out.println(encryption(n, lst, lst.size()));
        }
    }

    public static String encryption(int n, List<String> lst, int size) {
        String[] res = new String[lst.size()];
        int lcv = 0, ptr = 0;

        while (!lst.isEmpty()) {
            res[ptr] = lst.get(0).toUpperCase();
            lst.remove(0);

            if (ptr + n >= size)
                ptr = ++lcv;
            else
                ptr += n;
        }

        return String.join("", res);
    }
}
