import java.util.Scanner;

public class Sibice {

    static String test = "5 3 4\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "6\n" +
            "7";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testcases = s.nextInt();
        int width = s.nextInt();
        int height = s.nextInt();

        double cross = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        while (testcases-- != 0) {
            if (s.nextInt() <= cross) {
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }
    }
}
