import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 2992. 크면서 작은 수
 * 정수 X가 주어졌을 때, X와 구성이 같으면서 X보다 큰 수 중 가장 작은 수를 출력한다.
 * 수의 구성이 같다는 말은, 수를 이루고 있는 각 자리수가 같다는 뜻이다. 예를 들어, 123과 321은 수의 구성이 같다. 하지만, 123과 432는 구성이 같지 않다.
 * 첫째 줄에 결과를 출력한다. 만약 그러한 숫자가 없는 경우에는 0을 출력한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(nextLarger(br.readLine())); //156
    }

    public static int nextLarger(String x) {
        List<Integer> comb = new ArrayList<>();
        boolean[] visited = new boolean[x.length()];

        getCombinations(comb, x.toCharArray(), visited, new StringBuffer());
        comb = comb.stream().sorted().collect(Collectors.toList());

        for (int c : comb)
            if (Integer.parseInt(x) < c)
                return c;

        return 0;
    }

    public static void getCombinations(List<Integer> comb, char[] arrX, boolean[] visited, StringBuffer temp) {
        if (temp.length() == arrX.length) { //조합을 만든 숫자와 입력한 x의 자릿수가 같으면 comb에 add
            comb.add(Integer.parseInt(temp.toString()));
            return ;
        }

        for (int i = 0; i < arrX.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.append(arrX[i]);
                getCombinations(comb, arrX, visited, temp);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
    }
}
