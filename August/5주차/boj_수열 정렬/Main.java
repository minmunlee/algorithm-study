import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] idxResister = new int[N][2];

        for(int i=0; i<N; i++) {
            idxResister[i][0] = arr[i];
            idxResister[i][1] = i;
        }

        Arrays.sort(idxResister, (o1, o2) -> {
            if(o1 == o2) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for(int i=0; i<N; i++) {
            result[idxResister[i][1]] = i;
        }

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}