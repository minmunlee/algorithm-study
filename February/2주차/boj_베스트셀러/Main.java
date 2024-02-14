import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new HashMap<>();
        String[] key = new String[n];
        int max = 0;
        ArrayList<String> res = new ArrayList<>();
        String[] s;

        for (int i = 0; i < n; i++)
            key[i] = br.readLine();

        for (String str : key) {
            if (hm.containsKey(str))
                hm.put(str, hm.get(str)+1);
            else
                hm.put(str, 1);
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
        System.out.println(res.get(0));

        br.close();
    }
}