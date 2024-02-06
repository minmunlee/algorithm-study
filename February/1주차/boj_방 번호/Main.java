import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 1475. 방 번호
 * 다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
 * 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
 * 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
 * (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findCount(br.readLine()));
    }

    public static int findCount(String str) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('0', 0);
        map.put('1', 0);
        map.put('2', 0);
        map.put('3', 0);
        map.put('4', 0);
        map.put('5', 0);
        map.put('6', 0);
        map.put('7', 0);
        map.put('8', 0);
        map.put('9', 0);

        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        int tmp = map.get('6') + map.get('9');
        if (tmp > 0) { //6이나 9 둘 중 하나라도 있으면
            if (tmp % 2 == 0) { //둘을 더한 반 값의 나머지가 0이면 반씩 제하여 값 변경
                map.replace('6', tmp / 2);
                map.replace('9', tmp / 2);
            }
            else { //나머지가 1이면 소수점을 반올림하여 값 변경
                map.replace('6', (int) Math.ceil((double) tmp / 2));
                map.replace('9', (int) Math.ceil((double) tmp / 2));
            }
        }

        return Collections.max(map.values()); //values 중 max 값 리턴
    }
}
