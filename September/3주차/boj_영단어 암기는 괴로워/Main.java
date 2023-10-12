import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        

        for(int i = 0; i < N; i++){
            String w = br.readLine(); // 입력한 단어 하나씩 변수에 담아서 조건에 따라 해시맵 정보 추가
            if(w.length() < M){
                continue;
            }
            if(hm.containsKey(w)){
                hm.put(w, hm.get(w) + 1);
            }else{
                hm.put(w, 1);
            }

        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());

        Collections.sort(list, Map.Entry.comparingByKey());
        
        Collections.sort(list, (a, b) -> Integer.compare(b.getKey().length(), a.getKey().length()));
        
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey());
        }

        

    }   
}

