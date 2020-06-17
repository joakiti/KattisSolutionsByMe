import java.util.Scanner;

public class GrassSeedInc {

    static String test = "0.75\n" +
            "2\n" +
            "2 3.333\n" +
            "3.41 4.567";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double price = s.nextDouble();
        int noLawns = s.nextInt();

        double total = 0;
        while (noLawns-- != 0) {
            double w = s.nextDouble();
            double l = s.nextDouble();
            total += price * (l*w);
        }
        System.out.println(total);
    }
}
