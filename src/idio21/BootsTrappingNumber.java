package idio21;

import java.util.Scanner;

public class BootsTrappingNumber {

    static String test = "8561921412\n";

    public static void main(String[] args) {
        double n = new Scanner(test).nextDouble();

        double j = Math.log(n);
        double previousSample = -1;
        while (true) {
            double sample = newtonsMethod(j, n);
            System.out.println(sample);
            if (Math.abs(Math.pow(sample, Math.abs(sample)) - n) < 0.000001) {
                System.out.println(sample);
                break;
            }
            if (sample == previousSample) {
                j /= 2;
                System.out.println("new sample");
            }
            previousSample = j;
            j = sample;
        }

    }

    private static double newtonsMethod(double Xn, double n) {
        return Xn - ((Math.pow(Xn, Xn)  - n) / (Math.pow(Xn, Xn) * (Math.log(Xn) + 1)));
    }
}
