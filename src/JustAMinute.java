import java.util.Scanner;

public class JustAMinute {

    static String test = "3\n" +
            "5 560\n" +
            "10 600\n" +
            "2 264\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int secondsSum = 0;
        int minuttesSum = 0;

        while (n-- != 0) {
            minuttesSum += s.nextInt();
            secondsSum += s.nextInt();
        }
        double average = secondsSum / 60. / minuttesSum;
        if (average <= 1.0) {
            System.out.println("measurement error");
        } else {
            System.out.println(average);
        }
    }
}
