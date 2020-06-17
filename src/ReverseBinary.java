import java.util.Scanner;

public class ReverseBinary {


    static String test = "13";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println(decimalValueOf(Integer.toBinaryString(n)));
    }

    private static int decimalValueOf(String reverse) {
        int total = 0;
        for (int i = 0; i < reverse.length(); i++) {
            total += Math.pow(2, i) * Integer.parseInt(String.valueOf(reverse.charAt(i)));

        }
        return total;
    }
}
