/*
 * 2512. 예산
 * 국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것이다.
 * 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있다. 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정한다.
 *
 * 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
 * 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
 *
 * 입력 예 (반례)
 * 2
 * 10 20
 * 12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()); //지방 개수
        List<Integer> lst = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted() //이분탐색을 위한 정렬
                .collect(Collectors.toList()); //요청예산액
        int budget = Integer.parseInt(br.readLine()); //국가예산

        System.out.println(findLimit(count, lst, budget));

    }

    public static int findLimit(int count, List<Integer> lst, int budget) {
        int left = 0; //min 요청액보다 국가예산이 더 적을 수 있으므로 left를 0
        int right = lst.get(count - 1); //첫 right는 예산안의 max 값
        int mid; //가상한액(중간값)
        int sum;
        int limit = 0; //상한액

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2; //중간값 도출

            for (int i : lst)
                sum += Math.min(i, mid); //요청예산액과 가상한액을 비교하여 상한액 이상일 경우 가상한액을 배정하여 더함

            if (sum <= budget) {
                limit = mid; //요청예산액을 모두 더한 값이 국가예산을 이하라면 일단 상한액으로 잡음
                left = mid + 1; //가상한액에 1을 더해 루프를 돌리며 최대한의 값을 도출 lst값을 +1 하면
            } else
                right = mid - 1; //요청예산액을 모두 더한 값이 국가예산을 초과하면 가상한액을 1 줄여 적정값 도출

        }

        return limit; //최종 상한액 리턴
    }
}