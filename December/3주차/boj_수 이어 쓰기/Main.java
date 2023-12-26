import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String num = br.readLine(); // 예) 1234, 234092
                String i = "0"; // 증가하면서 N 구하는 수
                while(num.length() > 0) {
                        i = String.valueOf(Integer.parseInt(i)+1);
                        String number = i;
                        while(number.length() > 0 && num.length() > 0) {
                                if(num.charAt(0) == number.charAt(0)) {
                                        num = num.substring(1);
                                }
                                number = number.substring(1);
                        }
                }
                System.out.print(i);
        }
}