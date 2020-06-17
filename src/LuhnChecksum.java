import java.util.Scanner;

public class LuhnChecksum {

    static String test = "3\n" +
            "00554\n" +
            "999\n" +
            "1234567890123411";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0) {
            String number = s.next();
            String numberInReverse = new StringBuilder(number).reverse().toString();
            int sum = 0;
            for (int i = 0; i < numberInReverse.length(); i++) {
                int i1 = Integer.parseInt(String.valueOf(numberInReverse.charAt(i)));
                if (i%2 == 0) {
                    sum += i1;
                }
                else {
                    int d = 2* i1;
                    if (d >= 10) {
                        d = Integer.parseInt(String.valueOf(String.valueOf(d).charAt(0))) + Integer.parseInt(String.valueOf(String.valueOf(d).charAt(1)));
                    }
                    sum += d;
                }
            }
            if (sum % 10 == 0) {
                System.out.println("PASS");
            }
            else {
                System.out.println("FAIL");
            }
        }
    }
}
