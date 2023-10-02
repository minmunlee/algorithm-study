import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); // 입력 받을 수의 개수
        int n2 = sc.nextInt(); // 몇 번째 사람인지
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int count = 1;

        for(int i = 1; i <= n1; i++){ // 수 입력 받기
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            if(count != n2){ // n2 번째가 나올 때 까지 돌림
                queue.offer(queue.poll()); 
                count++;
            }else{
                list.add(queue.poll()); // 뺄 값 list 에 넣음
                count = 1;
            }
        }

        System.out.print("<");
        for(int i = 0; i < list.size(); i++){
            if(i == list.size() - 1){
                System.out.print(list.get(i) + ">");
            }else{
                System.out.print(list.get(i) + ",");
            }
        }
        
        sc.close();
    }
}
