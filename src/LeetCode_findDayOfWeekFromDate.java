import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class LeetCode_findDayOfWeekFromDate {

    public static String dayOfTheWeek(int day, int month, int year) {
        return LocalDateTime.of(year, month, day, 0, 0).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(27, 7, 2020));
    }

}
