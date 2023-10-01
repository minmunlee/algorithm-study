import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 입력 값 문자열로 받기
        String sArr[] = s.split("");  // 각각의 요소들을 분리
        List<String> list = new ArrayList<String>(Arrays.asList(sArr)); // 리스트로 저장
        List<Integer> intList = new ArrayList<Integer>(); // 계산할 값들을 저장하는 리스트
        int answer = 0;

        Stack<String> allStack = new Stack<>(); // 전체 배열 넣을 스택
        Stack<String> operStack = new Stack<>(); // + - * / 넣을 스택

        for(int i = 0; i < list.size(); i++){
            allStack.push(list.get(i)); // 모든 값 스택에 push
        }

        for(int i = 0; i <= allStack.size() / 2 - 1; i++){ // 피연산자는 연산자보다 항상 값의 개수가 하나 더 많음
            operStack.push(allStack.pop()); // 연산자를 operStack에 저장
        }

        while(!operStack.isEmpty()){
            // intList에 연산 할 두개를 넣음
            intList.add(Integer.parseInt(allStack.pop()));
            intList.add(Integer.parseInt(allStack.pop()));
    
            String pop = operStack.pop(); // 먼저 계산해줄 연산자를 뺌
            if(pop.charAt(0) == '+'){
                answer = intList.get(0) + intList.get(1);
            }else if(pop.charAt(0) == '-'){
                answer = intList.get(0) - intList.get(1);
            }else if(pop.charAt(0) == '*'){
                answer = intList.get(0) * intList.get(1);
            }else if(pop.charAt(0) == '/'){
                answer = intList.get(0) / intList.get(1);
            }
            intList.clear(); // 값을 구했으면 새로운 값을 계산하기 위해 리스트를 비움
            allStack.push(String.valueOf(answer)); // 먼저 계산 된 값과 계산이 안된 값을 계산하기 위해 push
        }

        System.out.println(answer);


    }

}
