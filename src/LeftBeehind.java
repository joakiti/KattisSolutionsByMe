import java.util.Scanner;

public class LeftBeehind {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        while (true) {
            int sweet = s.nextInt();
            int sour = s.nextInt();

            if (sweet == 0 && sour == 0) {
                break;
            }

            if (sweet + sour == 13) {
                System.out.println("Never speak again.");
            } else if (sour > sweet) {
                System.out.println("Left beehind.");
            } else if (sweet > sour) {
                System.out.println("To the convention.");
            } else if (sweet == sour) {
                System.out.println("Undecided.");
            }
        }

    }
}
