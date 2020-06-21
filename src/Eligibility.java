import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Eligibility {

    static String test = "3\n" +
            "EligibleContestant 2013/09/01 1995/03/12 10\n" +
            "IneligibleContestant 2009/09/01 1990/12/12 50\n" +
            "PetitionContestant 2009/09/01 1990/12/12 35\n";

    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Date from2010 = new Date(109, Calendar.DECEMBER,31);
        Date from1991 = new Date(90, Calendar.DECEMBER,31);
        while (n-- != 0) {
            String name = s.next();
            System.out.printf("%s ", name);
            Date dateOne = new SimpleDateFormat("yyyy/MM/dd").parse(s.next());
            Date dateTwo = new SimpleDateFormat("yyyy/MM/dd").parse(s.next());
            int courses = s.nextInt();
            if (dateOne.after(from2010)) {
                System.out.print("eligible");
                System.out.println();
                continue;
            }
            if (dateTwo.after(from1991)) {
                System.out.print("eligible");
                System.out.println();
                continue;
            }
            if (courses >= 41) {
                System.out.print("ineligible");
                System.out.println();
                continue;
            }
            System.out.print("coach petitions");
            System.out.println();
        }
    }
}
