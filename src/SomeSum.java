import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SomeSum {

    static String test = "1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Random r = new Random();
        int R = 10000;
        Boolean isEven = null;
        while (R-- != 0) {
            int range = r.nextInt(100 - n);
            int sum = IntStream.rangeClosed(range, range + n - 1).sum();
            if (sum % 2 == 0 && isEven != null && !isEven) {
                System.out.println("Either");
                System.exit(0);
            }
            if (sum % 2 == 0) {
                isEven = true;
            } else if (sum % 2 == 1) {
                isEven = false;
            }
        }
        if (isEven) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
