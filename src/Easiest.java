import java.util.Scanner;

public class Easiest {

    static String test = "3029\n" +
            "4\n" +
            "5\n" +
            "42\n" +
            "0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String next = s.next();
        while (Integer.parseInt(next) != 0) {
            int sum = sumOfDigits(next);
            int p = 11;
            while (sum != sumOfDigits(String.valueOf(p*Integer.parseInt(next)))) {
                p++;
            }
            System.out.println(p);
            next = s.next();
        }
    }

    private static int sumOfDigits(String s) {
        int total = 0;
        for (char c :
                s.toCharArray()) {
            total += Integer.parseInt(String.valueOf(c));
        }
        return total;
    }

}
