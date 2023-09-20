import java.util.*;

public class Main {
    int top = -1;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt(); // 입력 받을 수의 개수
        ArrayList<Integer> inputArray = new ArrayList<>(); // 입력 받은 수의 배열
        ArrayList<Integer> stackArray= new ArrayList<>(); // 스택 배열
        ArrayList<String> charArray = new ArrayList<String>(); // +, - 문자 저장할 배열

        int newnum = 0; // 1 - n 까지 증가하는 값

        for(int i = 0; i < num; i++){
            inputArray.add(scanner.nextInt()); // 수 입력 받기
        }

        for(int i : inputArray){
            while(!stackArray.contains(i)) { // stackArray에 입력 한 값이 있을 때까지 반복
                stackArray.add(++newnum);
                charArray.add("+");
            }
            if(stackArray.get(stackArray.size() - 1) == i){ // stackArray 마지막 값이 입력한 수와 일치 할 때
                stackArray.remove(stackArray.size()-1); // 최상단 값 제거
                charArray.add("-");
            }else{
                System.out.println("NO");
                System.exit(0);
            }
        }

        for (String i : charArray) {
            System.out.println(i);
        }

        scanner.close();
    }
}