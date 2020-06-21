import java.util.Scanner;

public class Prsteni {

    static String test = "4\n" +
            "12 3 8 4";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int r = s.nextInt();
        int first = s.nextInt();
        while (r-- != 1) {
            int denominator = s.nextInt();
            int numerator = first;
            for (int i = Math.min(denominator, numerator); i > 0; i--) {
                if (denominator % i == 0 & numerator % i == 0) {
                    denominator /= i;
                    numerator /= i;
                }
            }
            System.out.printf("%d/%d", numerator, denominator);
            System.out.println();

        }
    }
}
