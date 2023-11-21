import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                // 체스판 크기 입력
                StringTokenizer st = new StringTokenizer(br.readLine());
                int column = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                // 체스판 배열에 넣기
                String[][] arr = new String[column][row];
                for(int i=0; i<column; i++) {
                    String str = br.readLine();
                    for(int j=0; j<row; j++) {
                        arr[i][j] = str.substring(j, j+1);
                    }
                }

                // 8x8로 체스판을 순회할 수 있는 모든 경우를 순회할 것임.
                // 한 경우마다 다시 칠한 수를 저장할 배열 선언
                // *2를 한 이유 -> 체스판 첫 시작이 "B"일때와 "W"일때 두가지 경우를 모두 생각해야 하기 때문.
                int[] changeCount = new int[(column-7) * (row-7) * 2];
                int idx=0;

                
                for(int s=0; s<=column-8; s++) { // 맨 왼쪽부터 시작
                    for(int i=0; i<=row-8; i++) { // 맨 윗줄부터 시작
                        String color = "W"; // 첫 시작이 "W"일 때부터 생각하기
                        for(int j=0; j<2; j++) { // 첫 시작이 "W"때와 "B"일때 두가지를 모두 검사하기 위한 반복문

                            // 배열 순회 시작!
                            for(int p=i; p<i+8; p++) { 
                                for(int k=s; k<s+8; k++) {
                                    if(!arr[k][p].equals(color)) { // 색을 바꿔야 할 때를 판정
                                        changeCount[idx]++;
                                    }
                                    if(k == s+7) continue; // 다음줄로 넘어갈 때는 색을 바꾸지 않음.
                                    
                                    // 색이 번갈아 나오기 때문에 다음 인덱스로 갈때마다 색을 바꿔줌.
                                    if(color.equals("W")) color = "B"; 
                                    else color = "W";
                                }
                            }
                            color = "B"; // 첫 시작이 "B"일 때를 판정하기 위함.
                            idx++; // 다음 8X8 체스판의 다시 칠한 수를 저장하기 위해 인덱스 증가
                        } 
                    }
                }
                System.out.print(Arrays.stream(changeCount).min().getAsInt());
        }
}