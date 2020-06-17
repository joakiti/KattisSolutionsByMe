import java.util.Scanner;

public class EstimatingTheAreaOfACircle {

    static String test = "1.0 100 75\n" +
            "10.0 5000 4023\n" +
            "3.0 21 17\n" +
            "0 0 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            double r = s.nextDouble();
            double m = s.nextDouble();
            double c = s.nextDouble();
            if (r == 0) {
                System.exit(0);
            }

            double ratio = c/m;
            double areaOfSquare = (2*r) * (2*r);
            double result = areaOfSquare*ratio;

            System.out.printf("%f %f", Math.PI * Math.pow(r, 2), result );
            System.out.println();
        }
    }
}
