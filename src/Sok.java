import java.util.Scanner;

public class Sok {
    static String test = "10 15 18\n" +
            "3 4 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int orange = s.nextInt();
        int apple = s.nextInt();
        int pineapple = s.nextInt();

        double orangeRatio = s.nextDouble();
        double appleRatio = s.nextDouble();
        double pineappleRatio = s.nextDouble();

        double cocktailsAvailableForOrange = orange / orangeRatio;
        double cocktailsAvailableForApple = apple / appleRatio;
        double cocktailsAvailableForPineappl = pineapple / pineappleRatio;
        double dominatingLiquid = Math.min(cocktailsAvailableForApple, Math.min(cocktailsAvailableForOrange, cocktailsAvailableForPineappl));
        System.out.print(orange - dominatingLiquid * orangeRatio + " \n");
        System.out.print(apple - dominatingLiquid * appleRatio + " \n");
        System.out.print(pineapple - dominatingLiquid * pineappleRatio);
    }
}
