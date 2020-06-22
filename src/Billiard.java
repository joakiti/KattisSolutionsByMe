import java.util.Scanner;

public class Billiard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (a == 0) {
                break;
            }
            double distX = a * m;
            double distY = b * n;
            double distTotal = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
            double velocity = distTotal / s;
            double angle = 180.0 * Math.acos(distX / distTotal) / Math.PI;
            System.out.printf("%.2f %.2f\n", angle, velocity);

        }

    }
}
