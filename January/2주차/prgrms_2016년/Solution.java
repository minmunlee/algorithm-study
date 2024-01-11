import java.time.DayOfWeek;
import java.time.LocalDate;
class Solution {
    public String solution(int a, int b) {
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        LocalDate date = LocalDate.of(2016, a, b);
        int dayIndex = date.getDayOfWeek().getValue()-1;
        return day[dayIndex];
    }
}