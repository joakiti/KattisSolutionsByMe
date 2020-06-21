import java.util.Scanner;

public class PizzaCrust {

    static String test = "2 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int r = s.nextInt();
        int c = s.nextInt();

        double areaPizza = Math.PI * r * r;
        double areaWithCheese = Math.PI * (Math.pow(r - c, 2));
        if (areaWithCheese == 0) {
            System.out.println(0);
        } else {
            double ratio = areaPizza / areaWithCheese;
            System.out.printf("%f", (1/ratio) * 100);
        }
    }
}
