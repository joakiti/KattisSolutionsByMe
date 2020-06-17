import java.util.Scanner;

public class LicenseToLaunch {

    static String test = "5\n" +
            "3 4 1 7 2";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int days = s.nextInt();

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < days; i++) {
            int n = s.nextInt();
            if (n < min) {
                index = i;
                min = n;
            }
        }
        System.out.println(index);

    }
}
