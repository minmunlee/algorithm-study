import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> people = new ArrayList<>();  // 모든 사람들의 카드 정보
        List<Integer> max = new ArrayList<>(); // 세 수를 더한 값 중 가장 큰 값을 저장하는 리스트
        List<Integer> tmp = new ArrayList<>(); // 사람 한명씩 정보를 가져올 리스트
        
        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            List<Integer> cardNum = new ArrayList<Integer>(); // 한 사람이 갖는 카드 리스트
            for(int j = 0; j < 5; j++){
                cardNum.add(Integer.parseInt(str.nextToken()));
            }
            people.add(cardNum); // 한 사람 카드 정보 추가
        }
        
        for(int i = 0; i < people.size(); i++){
            tmp = people.get(i); // 사람 한 명 정보 가져오기
            List<Integer> sum = new ArrayList<>(); // 더한 값을 저장할 리스트
            for(int c1 = 0; c1 <= tmp.size() - 3; c1++){
                for(int c2 = c1 + 1; c2 <= tmp.size() - 2; c2++){
                    for(int c3 = c2 + 1; c3 <= tmp.size() - 1; c3++){
                        sum.add((tmp.get(c1) + tmp.get(c2) + tmp.get(c3)) % 10);
                    }
                }
            }
            max.add(Collections.max(sum)); // 더한 값중 가장 큰 값 리스트에 저장
        }
        

        int info = max.get(0); // 첫번째 사람의 합 정보
        int idx = 0; // 몇번째 사람인지 

        for(int i = 0; i < max.size(); i++){
            if(max.get(i) >= info){ // 앞 사람보다 합이 클 경우
                info = max.get(i);
                idx  = i + 1; // 뒷 사람으로 넘어감
            }
        }

        System.out.println(idx);
        

    }
    
}
