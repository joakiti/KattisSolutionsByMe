import java.util.Scanner;

public class SimonSays {

    static String test = "3\n" +
            "Simon says raise your right hand.\n" +
            "Lower your right hand.\n" +
            "Simon says raise your left hand.";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        while (n-- != 0) {
            String simonSays = s.nextLine();
            if (simonSays.startsWith("Simon says")) {
                System.out.println(simonSays.split("Simon says ")[1]);
            }
        }
    }
}
