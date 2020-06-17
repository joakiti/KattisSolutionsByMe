import java.util.Scanner;

public class NumberFun {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            double a = s.nextDouble();
            double b = s.nextDouble();
            double c = s.nextDouble();
            if (a+b == c || a*b==c || a/b == c || b/a == c || a-b == c || b-a == c) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }
        }
    }
}
