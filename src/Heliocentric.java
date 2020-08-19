import java.util.Scanner;

public class Heliocentric {

    static String test =
            "0 1\n" +
            "1 0\n";

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in  );
        int daysOnEarth = 365;
        int daysOnMars = 687;
        int testCase = 1;
        while (s.hasNext()) {
            int dayCounter = 0;
            int dayEarth = s.nextInt();
            int dayMars = s.nextInt();
            int daysUntilMarsAtZero = daysOnMars - dayMars;
            while (dayEarth != 0 || dayMars != 0) {
                dayEarth += daysUntilMarsAtZero;
                dayCounter += daysUntilMarsAtZero;
                dayEarth %= daysOnEarth;
                daysUntilMarsAtZero = daysOnMars;
                dayMars = 0;
            }
            System.out.printf("Case %d: %d\n", testCase, dayCounter);
            testCase++;
        }
    }
}
