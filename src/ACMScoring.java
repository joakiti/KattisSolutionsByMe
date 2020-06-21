import java.util.Scanner;

public class ACMScoring {

    static String test = "3 E right\n" +
            "10 A wrong\n" +
            "30 C wrong\n" +
            "50 B wrong\n" +
            "100 A wrong\n" +
            "200 A right\n" +
            "250 C wrong\n" +
            "300 D right\n" +
            "-1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] pointPenalties = new int[100];

        int total = 0;
        int noProblems = 0;
        while (true) {
            int n = s.nextInt();
            if (n == -1) {
                System.out.printf("%d %d", noProblems, total);
                System.exit(0);
            }
            char team = s.next().toCharArray()[0];
            String correct = s.next();
            if (correct.equals("wrong")) {
                pointPenalties[team] += 20;
            }
            else {
                total += n + pointPenalties[team];
                noProblems++;
            }
        }
    }
}
