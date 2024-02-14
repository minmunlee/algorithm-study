import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new HashMap<>();
        int max = 0;
        ArrayList<String> res = new ArrayList<>();
        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        for (Integer i : hm.values()) {
            if (max < i)
                max = i;
        }

        for (Map.Entry<String, Integer> pair : hm.entrySet()) {
            if (max == pair.getValue())
                res.add(pair.getKey());
        }

        Collections.sort(res);
        System.out.println(res.getFirst());

        br.close();
    }
}