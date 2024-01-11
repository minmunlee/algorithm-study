import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 3024. 마라톤 틱택토
 *
 * 게임은 세 글자가 행, 열, 또는 대각선으로 연속할 때, 그 플레이어가 승리하며, 게임이 끝나게 된다.
 * 보드판의 상태가 주어졌을 때, 게임이 끝났는지 아닌지를 결정하고, 끝났다면 승자가 누구인지 구하는 프로그램을 작성하시오.
 *
 * 입력 예
 * 3
 * XOC
 * XOC
 * X..
 */

public class Main {
    static int dx[] = new int[]{0, 1, 1, -1};
    static int dy[] = new int[]{1, 0, 1, 1}; //아래쪽, 오른쪽, 오른쪽 아래, 왼쪽 아래
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++)
            arr[i] = br.readLine().split("");

        System.out.println(findWinner(arr));
    }

    public static String findWinner(String[][] arr) {
        int nx, ny, count;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!arr[i][j].equals(".")) {
                    for (int k = 0; k < dx.length; k++) { //dx dy 길이만큼 루프
                        count = 1;

                        for (int l = 1; l <= 2; l++) { //3개가 같은지 봐야하기 때문에 시작점 + 한 칸, 시작점 + 두 칸 -> 총 두 번 루프
                            nx = j + l * dx[k];
                            ny = i + l * dy[k];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[i][j].equals(arr[ny][nx]))
                                //nx ny가 유효값이면서 시작점 문자와 같으면 count를 1 증가
                                count++;
                        }

                        if (count == 3) //승리자는 한 명이므로 바로 값 반환
                            return arr[i][j];

                    }
                }
            }
        }

        return "ongoing";
    }
}
