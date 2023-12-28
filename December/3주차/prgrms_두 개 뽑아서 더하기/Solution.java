import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public  List<Integer> solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        int temp;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                temp = numbers[i] + numbers[j];
                if (!result.contains(temp))
                    result.add(temp);
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }
}