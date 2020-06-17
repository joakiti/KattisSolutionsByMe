import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SymmetricOrder {

    static String test = "15\n" +
            "Bo\n" +
            "Pat\n" +
            "Jean\n" +
            "Kevin\n" +
            "Claude\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "William\n" +
            "Marybeth\n" +
            "1\n" +
            "Jim\n" +
            "5\n" +
            "John\n" +
            "Bill\n" +
            "Fran\n" +
            "Stan\n" +
            "Cece\n" +
            "0";

    static String testOne = "3\n" +
            "Bo\n" +
            "Pat\n" +
            "Frederick\n" +

            "0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int lengthListOne = (int) Math.ceil(n / (double) 2);
        int lengthListTwo = n / 2;
        String[] pairOne = new String[lengthListOne];
        String[] pairTwo = new String[lengthListTwo];

        int cases = 1;
        while (true) {
            System.out.println("SET " + cases);
            if (n == 1) {
                System.out.println(s.next());
                n = s.nextInt();
                if (n == 0) {
                    break;
                }
                cases++;
                lengthListOne = (int) Math.ceil(n / (double) 2);
                lengthListTwo = n / 2;
                pairOne = new String[lengthListOne];
                pairTwo = new String[lengthListTwo];
                continue;
            }
            for (int i = 0; i < n / 2; i++) {
                pairOne[i] = s.next();
                pairTwo[i] = s.next();
                if (i == (n / 2) - 1 && lengthListOne != lengthListTwo) {
                    pairOne[i + 1] = s.next();
                }
            }
            for (int i = 0; i < lengthListOne; i++) {
                System.out.println(pairOne[i]);
            }
            for (int i = lengthListTwo - 1; i >= 0; i--) {
                System.out.println(pairTwo[i]);
            }

            cases++;

            n = s.nextInt();
            if (n == 0) {
                break;
            }
            lengthListOne = (int) Math.ceil(n / (double) 2);
            lengthListTwo = n / 2;
            pairOne = new String[lengthListOne];
            pairTwo = new String[lengthListTwo];
        }
    }
}
