import java.util.Scanner;

public class Sjecista {

    static String test = "4\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n == 3) {
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(n*(n-1)*(n-2)*(n-3)/24);
    }
}
