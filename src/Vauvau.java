import java.util.Scanner;

public class Vauvau {

    static String test = "2 3 4 5\n" +
            "4 9 5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int dogAAgg = s.nextInt();
        int dogACalm = s.nextInt();
        int dogBAgg = s.nextInt();
        int dogBCalm = s.nextInt();
        int durA = dogAAgg + dogACalm;
        int durB = dogBAgg + dogBCalm;

        for (int i = 0; i < 3; i++) {
            int arrivalTime = s.nextInt();
            int intervalA = arrivalTime % durA;
            int intervalB = arrivalTime % durB;
            int countAttack = 0;

            if (intervalA > 0 && intervalA <= dogAAgg) {
                countAttack++;
            }
            if (intervalB > 0 && intervalB <= dogBAgg) {
                countAttack++;
            }
            switch (countAttack) {
                case 0:
                    System.out.println("none");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("both");
            }

        }

    }
}
