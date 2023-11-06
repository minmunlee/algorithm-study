import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력 할 땅의 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 현재 땅의 병사 수
            StringBuilder sb = new StringBuilder();
            int check = 1; // SYJKGW 인 경우

            while (st.hasMoreTokens()) {
                sb.append(Integer.parseInt(st.nextToken())); // 병사 데이터 저장
            }

            StringTokenizer nst = new StringTokenizer(sb.toString()); //  병사 데이터를 저장한 stringBuilder 안에서 토큰화
            HashMap<Integer, Integer> hm = new HashMap<>(); // 각 병사별 등장 횟수 저장

            while (nst.hasMoreTokens()) {
                int num = Integer.parseInt(nst.nextToken()); // 병사들 한명씩 변수에 담음
                if (hm.containsKey(num)) { // 이미 해시맵에 저장된 값일 때
                    hm.put(num, hm.get(num) + 1);
                    if (hm.get(num) > c / 2) { // 횟수가 절반을 넘을 경우
                        System.out.println(num);
                        check = 0;
                        break;
                    }
                } else { // 해시맵에 저장되지 않은 새 병사일 때
                    hm.put(num, 1);
                }
            }

            if (check == 1) {
                System.out.println("SYJKGW");
            }
        }
    }
}
