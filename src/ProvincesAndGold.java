import java.util.Scanner;

public class ProvincesAndGold {
    static String test = "0 0 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int gold = s.nextInt();
        int silver = s.nextInt();
        int copper = s.nextInt();

        int buyingPower = copper + silver * 2 + gold * 3;

        if (buyingPower >= 8) {
            System.out.print("Province");
        } else if (buyingPower >= 5) {
            System.out.print("Duchy");
        } else if (buyingPower >= 2) {
            System.out.print("Estate");
        }
        if (buyingPower >= 2) {
            System.out.print(" or ");
        }
        if (buyingPower >= 6) {
            System.out.print("Gold");
        } else if (buyingPower >= 3) {
            System.out.print("Silver");
        } else {
            System.out.println("Copper");
        }
    }
}

