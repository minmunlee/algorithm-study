import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            StringTokenizer str;
            List<String> allSoundList = new ArrayList<>(); // 모든 동물 소리
            List<String> soundList = new ArrayList<>(); // 동물 소리 한줄씩
            HashMap<String, String> hm = new HashMap<String, String>(); // 동물 소리 저장
            str = new StringTokenizer(br.readLine());
            while(str.hasMoreTokens()){
                allSoundList.add(str.nextToken());
            }

            while (true) {
                str = new StringTokenizer(br.readLine());
                soundList = new ArrayList<>();
                
                while(str.hasMoreTokens()){
                    soundList.add(str.nextToken());
                }
    
                if(soundList.get(1).equals("goes")){
                    hm.put(soundList.get(0), soundList.get(2));
                }else{
                    break;
                }
            }

            for(int j = 0; j < allSoundList.size(); j++){
                if(!hm.containsValue(allSoundList.get(j))){
                    System.out.print(allSoundList.get(j) + " ");
                }
            }

            System.out.println();


            
        }
    }
    
}
