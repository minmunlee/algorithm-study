import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
 * 9536. 여우는 어떻게 울지?
 * 첫 번째 줄에는 테스트케이스의 개수 T가 입력된다. 각 테스트케이스는 아래와 같이 구성되어 있다.
 * 테스트케이스의 첫 줄에는 몇 개의 단어로 이루어진 녹음된 소리가 입력된다. 단어는 알파벳 소문자로만 이루어져 있으며 공백으로 구분된다.
 * 단어의 길이는 최대 100글자이고, 단어의 개수는 최대 100개이다. 다음 줄부터는 여우를 제외한 동물들의 울음소리가 <동물> goes <소리>의 형태로 입력된다.
 * 최소 1마리, 최대 100마리이며, 이름은 최대 100글자이고 실제로 존재하는 동물의 이름이다. 여우를 제외한 동물의 울음소리는 한 단어이고 최대 100글자이다.
 * 마지막 줄에는 한신이가 알고 싶어하는 질문이 주어진다. what does the fox say?
 *
 * 입력 예
 * 1
 * toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot
 * dog goes woof
 * fish goes blub
 * elephant goes toot
 * seal goes ow
 * what does the fox say?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> recording = new ArrayList<>(); //녹음된 소리
        List<String> noises = new ArrayList<>(); //동물들 울음 소리
        String str;


        for (int i = 0; i < n; i++) {
            recording.clear();
            noises.clear();

            recording = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
            while (true) {
                str = br.readLine();
                if (str.equals("what does the fox say?"))
                    break;
                noises.add(str.substring(str.lastIndexOf(" ") + 1)); //공백 기준 마지막 문자열만 noises에 add
            }

            System.out.println(foxBark(recording, noises));
        }
    }

    public static String foxBark(List<String> recording, List<String> noises) {

        for (String noise : noises) {
            if (recording.contains(noise))
                while (recording.remove(noise)) {} //noise가 recording에 있으면 반복문을 통해 전체 삭제
        }

        return String.join(" ", recording);
    }
}