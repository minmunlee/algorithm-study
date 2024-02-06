import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> p = Arrays.asList(participant)
                .stream().sorted().collect(Collectors.toList());;
        List<String> c = Arrays.asList(completion)
                .stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < c.size(); i++)
            if (!(p.get(i).equals(c.get(i))))
                return p.get(i);

        return p.get(p.size() - 1);
    }
}