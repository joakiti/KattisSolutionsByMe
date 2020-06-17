import java.util.List;
import java.util.Scanner;

public class Tri {

    static String test = "5 3 8";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if (a + b == c) {
            System.out.println(a + "+" + b + "=" + c);
        }
        else if (a*b == c) {
            System.out.println(a + "*" + b + "=" + c);
        }
        else if (a-b==c) {
            System.out.println(a + "-" + b + "=" + c);
        }
        else if (a/b==c) {
            System.out.println(a + "/" + b + "=" + c);
        }
        else if (a == b + c) {
            System.out.println(a + "=" + b + "+" + c);
        }
        else if (a == b / c) {
            System.out.println(a + "=" + b + "/" + c);
        }
        else if (a == b * c) {
            System.out.println(a + "=" + b + "*" + c);
        }
        else if (a == b - c) {
            System.out.println(a + "=" + b + "-" + c);

        }

    }
}
