import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 1515. 수 이어 쓰기
 *
 * 세준이는 1부터 N까지 모든 수를 차례대로 공백없이 한 줄에 다 썼다. 그리고 나서, 세준이가 저녁을 먹으러 나간 사이에 다솜이는 세준이가 쓴 수에서 마음에 드는 몇 개의 숫자를 지웠다.
 * 세준이는 저녁을 먹으러 갔다 와서, 자기가 쓴 수의 일부가 지워져있는 모습을 보고 충격받았다.
 * 세준이는 수를 방금 전과 똑같이 쓰려고 한다. 하지만, N이 기억이 나지 않는다.
 * 남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램을 작성하시오. 아무것도 지우지 않을 수도 있다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findNumber(Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList())));

    }

    public static int findNumber(List<Integer> lst) {
        int num = 0;
        String str;

        while (true) {
            str = String.valueOf(++num); //임의 숫자를 문자열 변환

            for (int i = 0; i < str.length(); i++) { //임의 숫자를 잘라 루프
                if (str.charAt(i) - '0' == lst.get(0))
                    lst.remove(0); //숫자의 한 요소와 리스트 맨 앞 요소가 같으면 리스트 맨 앞 요소 삭제
                if (lst.isEmpty())
                    return num; //리스트가 비었으면 임의 숫자(MinNum) 리턴
            }
        }
    }
}