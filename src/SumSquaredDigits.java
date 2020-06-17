import java.util.Scanner;

public class SumSquaredDigits {
    static String test = "3\n" +
            "1 10 1234\n" +
            "2 3 98765\n" +
            "3 16 987654321";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        for (int i = 1; i <= n ; i++) {
            int no = s.nextInt();
            int base = s.nextInt();
            int number = s.nextInt();
            int DDG = 0;
            while (number > 0) {
                int digits = (int) number % base;
                DDG += Math.pow(digits, 2);
                number = (number-digits) / base; //remove the 0 after having subtraced value of digit.
            }
            System.out.println(no + " " + DDG);
        }
    }
}
