import java.util.Scanner;

public class DasBlinkenlights {

    static String test = "4 4 4";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int intervalOne = s.nextInt();
        int intervalTwo = s.nextInt();

        int interval = s.nextInt();

        if (lcm(intervalOne, intervalTwo) <= interval) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    static int lcm(int a, int b) {
        int absHigherNumber = Math.max(a,b);
        int absLowerNumber = Math.min(a,b);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
