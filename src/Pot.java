import java.util.Scanner;

public class Pot {

    static String test = "5\n" +
            "23\n" +
            "17\n" +
            "43\n" +
            "52\n" +
            "22";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        s.nextInt();
        int total = 0;

        while (s.hasNext()) {
            String b = s.next();
            total += Math.pow(Integer.parseInt(b.substring(0, b.length() - 1)), Integer.parseInt(b.substring(b.length() - 1)));
        }
        System.out.println(total);
    }
}
