import java.util.Scanner;

public class Zamka {

    static String test = "1\n" +
            "100\n" +
            "4";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int l = s.nextInt();
        int d = s.nextInt();
        int x = s.nextInt();

        int j = l;
        while (numbersAddUp(j) != x) {
            j++;
        }
        while (numbersAddUp(d) != x) {
            d--;
        }
        System.out.println(j);
        System.out.println(d);

    }

    public static int numbersAddUp(int x) {
        String k = String.valueOf(x);
        int total = 0;
        for (char c : k.toCharArray()) {
            total += Integer.parseInt(String.valueOf(c));
        }
        return total;
    }

}
