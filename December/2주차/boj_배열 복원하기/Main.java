import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16967. 배열 복원하기
 * 크기가 H × W인 배열 A와 두 정수 X와 Y가 있을 때,
 * 크기가 (H + X) × (W + Y)인 배열 B는 배열 A와 배열 A를 아래로 X칸, 오른쪽으로 Y칸 이동시킨 배열을 겹쳐 만들 수 있다. 수가 겹쳐지면 수가 합쳐진다.
 * 배열 B와 정수 X, Y가 주어졌을 때, 배열 A를 구해보자.
 *
 * 입력 예
 * 2 4 1 1
 * 1 2 3 4 0
 * 5 7 9 11 4
 * 0 5 6 7 8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] b = new int[h + x][w + y];

        for (int i = 0; i < b.length; i++) { //배열 b 채우기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b[i].length; j++)
                b[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = x; i < h; i++) { //겹치는 부분 복원
            for (int j = y; j < w; j++) {
                b[i][j] -= b[i - x][j - y];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}