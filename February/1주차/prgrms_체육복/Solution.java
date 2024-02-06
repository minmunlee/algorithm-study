import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lst = Arrays.stream(lost)
                .boxed().sorted().collect(Collectors.toList());
        List<Integer> rsv = Arrays.stream(reserve)
                .boxed().sorted().collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {
            if (lst.contains(i) && rsv.contains(i)) {
                lst.remove(Integer.valueOf(i));
                rsv.remove(Integer.valueOf(i));
            }
        }

        for (int i = 0; i < rsv.size(); i++) {
            int r = rsv.get(i);
            if (lst.contains(r - 1))
                lst.remove(Integer.valueOf(r - 1));
            else if (lst.contains(r + 1))
                lst.remove(Integer.valueOf(r + 1));
        }

        return n - lst.size();
    }
}