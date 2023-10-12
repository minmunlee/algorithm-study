import java.io.BufferedReader;
import java.io.EOFException;
import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); // 한 일과 개수 담을 해시맵
        String[] arr = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"}; // 한 일 목록
        String data = ""; // 한 일을 담을 변수
        int count = 0; // 한 일의 총개수

        for(String s : arr){
            hm.put(s, 0);
        }

        while((data = br.readLine()) != null ){
            str = new StringTokenizer(data);
            while(str.hasMoreTokens()){
                count++;
                String nextString = str.nextToken();
                if(hm.containsKey(nextString)){
                    hm.put(nextString, hm.get(nextString) + 1);
                }
            }
        }

        for(int i = 0; i < 7; i++){
            System.out.println(String.format("%s %d %f", arr[i], hm.get(arr[i]), hm.get(arr[i]) / count));
        }
        System.out.println(String.format("Total %d 1.00", count));

    }
}
