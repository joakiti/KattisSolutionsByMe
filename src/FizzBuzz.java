import java.util.Scanner;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int fizz = s.nextInt();
        int buzz = s.nextInt();

        int n = s.nextInt();

        IntStream.rangeClosed(1, n).forEach((x) -> {
            if (x % fizz == 0 && x % buzz == 0) {
                System.out.println("FizzBuzz");
            }
            else if (x % fizz == 0) {
                System.out.println("Fizz");
            }
            else if (x % buzz == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(x);
            }
        } );
    }
}
