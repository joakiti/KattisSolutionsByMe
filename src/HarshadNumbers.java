import java.util.Scanner;

public class HarshadNumbers {

    static String test = "25";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (true) {
            if (isHardshad(n)) {
                System.out.println(n);
                System.exit(0);
            }
            else {
                n++;
            }
        }
    }

    private static boolean isHardshad(int n) {
        String s = String.valueOf(n);
        int sumOfDigits = 0;
        for (char c :
                s.toCharArray()) {
            sumOfDigits += Integer.parseInt(String.valueOf(c));
        }
        return n % sumOfDigits == 0;

    }
}
