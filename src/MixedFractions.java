import java.util.Scanner;

public class MixedFractions {

    static String test = "27 12\n" +
            "2460000 98400\n" +
            "3 4000\n" +
            "0 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (b == 0) {
                System.exit(0);
            }
            double whole = Math.floor(a/(double)b);
            double remainder = a % b;
            System.out.println((int) whole + " " + (int) remainder + " / " + b);
        }
    }
}
