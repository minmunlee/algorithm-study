import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int P = -1;

        for (int i = N - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) { // 이 자리번째(i-1 == P) 수만 다음 큰 수로 바꿔주고 나머지 뒤에 수를 정렬하면 됨
                P = i - 1;
                break;
            }
        }

        if (P == -1) {
            sb.append(-1);
        }
        else {
            List<Integer> imsi = Arrays.stream(Arrays.copyOfRange(arr, P, N)) // P ~ N-1번째 수까지 오름차순 정렬
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());

            int nextMaxIdx = imsi.indexOf(arr[P]) + 1; // P번째 수 그 다음으로 큰 수의 idx
            int imsiIdx = 0;

            for (int j = 0; j < N; j++) {
                if (j < P) { // 바꿀 필요 없는 앞 부분 숫자들
                    sb.append(arr[j]).append(" "); // 기존 숫자 그대로
                }
                else if (j == P) { // P 번째를 기존 수보다 다음 큰 수로
                    sb.append(imsi.get(nextMaxIdx)).append(" ");
                }
                else { // imsi 리스트에 남은 수 순서대로
                    sb.append(imsi.get(imsiIdx++)).append(" ");
                    if (imsiIdx == nextMaxIdx) imsiIdx++;
                }
            }
        }

        System.out.print(sb);
    }
}