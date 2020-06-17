package IsItHalloween;

import java.util.Scanner;

public class com {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        String a = s.nextLine();

        if (a.equals("OCT 31") | a.equals("DEC 25")) {
            System.out.println("yup");
        }
        else {
            System.out.println("nope");
        }
    }
}
