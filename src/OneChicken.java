import java.util.Scanner;

public class OneChicken {

    static String test = "2 3\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        if ( a < b) {
            String flertal = b-a == 1 ? "" : "s";
            System.out.printf("Dr. Chaz will have %d piece"+flertal+" of chicken left over!", b-a);
        }
        else {
            String flertal = a-b == 1 ? "" : "s";
            System.out.printf("Dr. Chaz needs %d more piece"+flertal+" of chicken!", a-b);
        }
    }
}
