import java.util.Scanner;

public class Faktor {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int denominator = s.nextInt();
        int impactGoal = s.nextInt();

        System.out.println(((impactGoal - 1) * denominator) + 1);
    }
}
