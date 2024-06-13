import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] room = new String[N][N];
        int rCnt = 0; // 세로 자리
        int cCnt = 0; // 가로 자리

        for(int i = 0; i < room.length; i++){
            String s = br.readLine();
            String[] str = s.split("");
            int idx = 0;

            for(String st : str){
                room[i][idx] = st;
                idx++;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 연속 두 자리가 비어있어야함. 누우면 벽에 닿거나 짐에 닿아야함
                if(j + 1 < N && room[i][j].equals(".") && room[i][j + 1].equals(".") && ((j + 2 == N) || room[i][j + 2].equals("X"))){
                    cCnt++;
                }

                if(i + 1 < N && room[i][j].equals(".") && room[i + 1][j].equals(".") && ((i + 2 == N) || room[i + 2][j].equals("X"))){
                    rCnt++;
                }
            }
        }

        System.out.println(cCnt + " " + rCnt);
    
    }
}
