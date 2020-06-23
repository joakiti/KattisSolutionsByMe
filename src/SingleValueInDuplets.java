import java.util.ArrayList;
import java.util.Scanner;

public class SingleValueInDuplets {


    static String test = "2 2 3 3 5 9 5 15 9 322 9283829 322 9283829";
    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        int x = 0;
        while (s.hasNext()) {
            x ^= s.nextInt();
        }
        System.out.println(x);
        test(89);
    }

    static int test(int n) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit*digit;
            }
            return sum;
        }
}
