import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
 * 9375. 패션왕신해빈
 * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 *
 * 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
 * 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
 *
 * (옷 개수 + 안 입는 경우)
 * 각 종류의 옷 개수 +
 *
 * 입력 예
 * 2
 * 3
 * hat headgear
 * sunglasses eyewear
 * turban headgear
 * 3
 * mask face
 * sunglasses face
 * makeup face
 */

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, String> map;
        long count;

        int n = Integer.parseInt(br.readLine()); //테스트케이스 수

        for (int i = 0; i < n; i++) { //테스트케이스 수만큼 루프

            int m = Integer.parseInt(br.readLine()); //옷 종류의 개수
            map = new HashMap<>(); //옷 이름, 종류를 담을 map 변수
            count = 1; //일수

            for (int j = 0; j < m; j++) { //옷 종류만큼 루프

                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                map.put(name, type); //type을 key로 하면 keySet() 메소드로 중복값이 사라지므로 value로 세팅하여 put

            }

            for (String s : map.values().stream().distinct().collect(Collectors.toList())) //values()의 중복값을 제거하여 옷의 종류만큼 루프
                //예를 들어 상의 개수가 2개라면, 첫 번째를 입거나(1), 두 번쨰를 입거나(2), 둘 다 안 입거나(3) 총 세 가지의 경우의 수가 있음
                count *= map.values().stream().filter(s::equals).count() + 1; //각 종류의 옷 개수 + 1(안 입는 경우)를 count에 곱함

            System.out.println(count - 1); //모든 종류 아무 것도 안 입는 경우를 제하기 위해 -1을 하여 리턴

        }
    }
}
