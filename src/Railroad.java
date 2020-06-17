import java.util.Scanner;

public class Railroad {

    static String test = "0 2";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();
        x= x*4;
        y = y*3;
        if ((x+y) % 2 == 0) {
            System.out.println("possible");
        }
        else {
            System.out.println("impossible");
        }
    }
}
