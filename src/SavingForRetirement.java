import java.util.Scanner;

public class SavingForRetirement {

    static String test = "20 25 5 20 5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int ageB = s.nextInt();
        int retB = s.nextInt();
        int moneyB = s.nextInt();

        int ageA = s.nextInt();
        int moneyA = s.nextInt();

        moneyB = Math.abs(retB - ageB) * moneyB;

        int retA = (int) (Math.ceil((moneyB + 1)/(double) moneyA) + ageA);

        System.out.println(retA);

    }
}
