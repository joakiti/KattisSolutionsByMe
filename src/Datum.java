import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Datum {

    static String test = "1 1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int day = s.nextInt();
        int month = s.nextInt();

        DayOfWeek x = DayOfWeek.from(LocalDate.of(2009, month, day));
        System.out.println(x.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));

    }
}
