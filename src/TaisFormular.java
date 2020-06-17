import java.util.Scanner;

public class TaisFormular {

    static String test = "3\n" +
            "1000 4.0\n" +
            "2000 8.0\n" +
            "3001 7.3";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int lastA = s.nextInt();
        double lastB = s.nextDouble();

        double totalArea = 0;
        for (int i = 0; i < n-1; i++) {
            int a = s.nextInt();
            double b = s.nextDouble();
            totalArea += (((b+lastB)/ (double) 2)*(a-lastA)) / 1000;
            lastA = a;
            lastB = b;
        }
        System.out.println(totalArea);
    }
}
