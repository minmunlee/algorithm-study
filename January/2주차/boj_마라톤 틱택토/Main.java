// 실패 코드 원인 분석 부탁드립니다 ..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String winner = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N][N];
        for(int i=0; i<N; i++) {
            board[i] = br.readLine().split("");
        }
        isGaroBingo(board);
        isSeroBingo(board);
        isdaegakseonBingo(board);
        if(winner.equals("")) System.out.print("ongoing");
        else System.out.print(winner);
    }

    public static void isGaroBingo(String[][] board) {
        String temp = "";
        int count = 1;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j].equals(".")) {
                    continue;
                }
                if(temp.equals(board[i][j])) {
                    count++;
                }
                else {
                    count = 1;
                }
                if(count == 3) {
                    winner = temp;
                    return;
                }
                temp = board[i][j];
            }
        }
    }

    public static void isSeroBingo(String[][] board) {
        String temp = "";
        int count = 1;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[j][i].equals(".")) {
                    continue;
                }
                if(temp.equals(board[j][i])) {
                    count++;
                }
                else {
                    count = 1;
                }
                if(count == 3) {
                    winner = temp;
                    return;
                }
                temp = board[j][i];
            }
        }
    }

    public static void isdaegakseonBingo(String[][] board) {
        String temp = "";
        int count = 1;
        for(int i=0, j=0; i<board.length; i++,j++) {
            if(board[i][j].equals(".")) {
                continue;
            }
            if(temp.equals(board[i][j])) {
                count++;
            }
            else {
                count = 1;
            }
            if(count == 3) {
                winner = temp;
                return;
            }
            temp = board[i][j];
        }
        count = 1;
        temp = "";
        for(int i= board.length-1, j=board.length-1; i>=0; i--,j--) {
            if(board[i][j].equals(".")) {
                continue;
            }
            if(temp.equals(board[i][j])) {
                count++;
            }
            else {
                count = 1;
            }
            if(count == 3) {
                winner = temp;
                return;
            }
            temp = board[i][j];
        }
    }
}