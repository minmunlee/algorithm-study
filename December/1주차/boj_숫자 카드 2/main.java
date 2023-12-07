import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 10816. 숫자 카드2
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 *
 * 입력 예
 * 10
 * 6 3 2 10 10 10 -10 -10 7 3
 * 8
 * 10 9 -5 2 3 4 5 -10
 */

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine(); //상근이가 가지고 있는 카드 개수
        String[] arr = br.readLine().split(" "); //상근이가 가진 카드들
        String m = br.readLine(); //주어진 카드 개수
        List<String> targets = Arrays.asList(br.readLine().split(" ")); //주어진 카드들
        Map<String, Integer> cards = new HashMap<>(); //(숫자, 카드 개수)로 이루어진 cards 변수

        for (String s : arr)
            //상근이가 가진 카드, 카드의 개수를 cards 변수에 put
            //value에 getOrDefault()를 사용하여 key값이 있으면 value + 1을, 없으면 1을 세팅
            cards.put(s, cards.getOrDefault(s, 0) + 1);

        System.out.println(findTargets(cards, targets));
    }

    public static String findTargets(Map<String, Integer> cards, List<String> targets) {
        StringBuffer sb = new StringBuffer();

        for (String target : targets) {
            if (cards.keySet().contains(target))
                sb.append(cards.get(target) + " "); //카드가 있으면 value값을 append
            else
                sb.append("0 "); //카드가 없으면 0을 append
        }

        return sb.toString();
    }

}


/*

시간초과남 !!!!

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S4_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        List<String> cards = Arrays.asList(br.readLine().split(" "));
        String m = br.readLine();
        List<String> targets = Arrays.asList(br.readLine().split(" "));

        List<String> res = findTargets(cards, targets);

        for (String i : res)
            System.out.print(i + " ");

    }

    public static List<String> findTargets(List<String> cards, List<String> targets) {
        List<String> res = new ArrayList<>();

        for (String i : targets)
            res.add(String.valueOf(cards.stream().filter(i::equals).count()));

        return res;
    }
}


 */