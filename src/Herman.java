import java.util.Scanner;

public class Herman {

    static String test = "1";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int r = s.nextInt();
        double radius = Math.PI * Math.pow(r, 2);
        double taxiRadius = Math.pow(r, 2) * 2;

        System.out.println(radius);
        System.out.println(taxiRadius);
    }
}
