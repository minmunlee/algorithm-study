import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class App {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();
                int N = Integer.parseInt(br.readLine());
                String[][] arr = new String[N][4];
                for(int i=0; i<N; i++) {
                        arr[i] = br.readLine().split(" ");
                }

                Arrays.sort(arr, new Comparator<String[]>() {
                        @Override
                        public int compare(String[] o1, String[] o2) {
                                if(o1[1].equals(o2[1])) {
                                        if(o1[2].equals(o2[2])) {
                                                if(o1[3].equals(o2[3])) {
                                                        return o1[0].compareTo(o2[0]);
                                                }
                                                return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                                        }
                                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                                }
                                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                        }
                });

                for(int i=0; i<N; i++) {
                        sb.append(arr[i][0]).append("\n");
                }
                System.out.print(sb);


                // 시간초과 ,,,,,,,, ㅜ
//                for(int i=0; i<N-1; i++) {
//                        for(int j=i; j<N; j++) {
//                                if(Integer.parseInt(arr[i][1]) < Integer.parseInt(arr[j][1])) { // 국어 점수 감소하는 순서로 정렬
//                                        String[] temp = arr[i];
//                                        arr[i] = arr[j];
//                                        arr[j] = temp;
//                                }
//                                else if(Integer.parseInt(arr[i][1]) == Integer.parseInt(arr[j][1])) {
//                                        if(Integer.parseInt(arr[i][2]) > Integer.parseInt(arr[j][2])) { // 영어 점수가 증가하는 순서로 정렬
//                                                String[] temp = arr[i];
//                                                arr[i] = arr[j];
//                                                arr[j] = temp;
//                                        }
//                                        else if(Integer.parseInt(arr[i][2]) == Integer.parseInt(arr[j][2])) {
//                                                if(Integer.parseInt(arr[i][3]) < Integer.parseInt(arr[j][3])) { // 수학 점수가 감소하는 순서로 정렬
//                                                        String[] temp = arr[i];
//                                                        arr[i] = arr[j];
//                                                        arr[j] = temp;
//                                                }
//                                                else if(Integer.parseInt(arr[i][3]) == Integer.parseInt(arr[j][3])) {
//                                                        if(arr[i][0].compareTo(arr[j][0]) > 0) { // 모든 점수가 같으면 이름을 사전 순, 증가하는 순서로 정렬
//                                                                String[] temp = arr[i];
//                                                                arr[i] = arr[j];
//                                                                arr[j] = temp;
//                                                        }
//                                                }
//                                        }
//                                }
//                        }
//                }
        }
}