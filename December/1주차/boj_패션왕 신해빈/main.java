import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();
                int testCase = Integer.parseInt(br.readLine());

                for(int i=0; i<testCase; i++) {
                        Map<String, Integer> map = new HashMap<>();
                        int n = Integer.parseInt(br.readLine());
                        for(int k=0; k<n; k++) { // 옷 종류와 종류별 옷 개수를 map에 저장
                                String category = br.readLine().split(" ")[1];
                                map.put(category, map.getOrDefault(category, 0) + 1);
                        }
                        int result = 1;
                        for(int value : map.values()) {
                                result *= (value + 1); // 해당 카테고리 옷을 안입는 경우까지 계산해야 해서 +1 해줌
                        }
                        sb.append(result - 1).append("\n"); // 알몸인 상태를 제외하기 위해서 -1 해줌
                }

                System.out.print(sb);
        }
}