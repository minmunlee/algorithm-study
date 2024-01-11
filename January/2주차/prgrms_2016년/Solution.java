import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }
}
