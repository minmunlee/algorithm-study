import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 2303. 숫자 게임
 * 게임을 이기기 위해서는 세 장의 카드를 선택할 때 그 합의 일의 자리 수가 가장 크게 되도록 선택하여야 한다.
 * N명에게 각각 다섯 장의 카드가 주어졌을 때, 세 장의 카드를 골라 합을 구한 후 일의 자리 수가 가장 큰 사람을 찾는 프로그램을 작성하시오.
 * 가장 큰 수를 갖는 사람이 두 명 이상일 경우에는 번호가 가장 큰 사람의 번호를 출력한다.
 *
 * 입력 예
 * 3
 * 7 5 5 4 9
 * 1 1 1 1 1
 * 2 3 3 2 10
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> lst;
        int maxNum = 0;
        int temp = 0;
        int result = 0;

        for (int n = 1; n <= N; n++) {
            lst = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            temp = findMaxNum(lst); //n번째 사람의 가장 큰 일의 자리 수를 temp에 저장
            if (maxNum <= temp) {
                //temp와 maxNum을 비교하여 더 크면 maxNum에, 해당하는 사람의 번호를 result에 저장
                maxNum = temp;
                result = n;
            }

        }

        System.out.println(result);
    }

    public static int findMaxNum(List<Integer> lst) {
        int maxNum = 0;

        for (int i = 0; i < lst.size() - 2; i++) {
            for (int j = i + 1; j < lst.size() - 1; j++) {
                for (int k = j + 1; k < lst.size(); k++) {
                    //현재 maxNum과 세 수를 더한 일의 자리 수를 비교하여 maxNum에 저장
                    maxNum = Math.max(maxNum, (lst.get(i) + lst.get(j) + lst.get(k)) % 10);
                }
            }
        }

        return maxNum;
    }

}