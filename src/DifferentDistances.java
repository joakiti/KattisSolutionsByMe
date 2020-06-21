import java.util.Scanner;

public class DifferentDistances {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            double x1 = s.nextDouble();
            if (x1 == 0) {
                break;
            }
            double y1 = s.nextDouble();
            double x2 = s.nextDouble();
            double y2 = s.nextDouble();
            double p = s.nextDouble();
            System.out.println(findDistance(x1, y1, x2, y2, p));
        }
    }

    static double findDistance(double x1, double y1, double x2, double y2, double p) {
        return Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1/p);
    }
}
