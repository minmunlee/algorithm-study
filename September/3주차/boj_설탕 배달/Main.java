import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배달 할 설탕의 양
        int count = 0; // 필요한 최소한의 봉지

        while(true){
            if(n % 5 == 0){ // 5의 배수인 경우
                System.out.println(count += n/5);
                break;
            }else if(n < 0){ // 3, 5의 배수 둘 다 아닌 경우
                System.out.println(-1);
                break;
            }
            // 3의 배수인 경우
            n -= 3;
            count += 1;
            
        }

        sc.close();

    }
}
