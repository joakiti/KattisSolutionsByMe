import java.util.Scanner;

public class ProblemBAvion {
    static String input = "47-FBI\n" +
            "BOND-007\n" +
            "RF-FBI18\n" +
            "MARICA-13\n" +
            "13A-FBILL";

    public static void main(String[] args ) {
        Scanner s = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i ++ ) {
            if (s.nextLine().contains("FBI")) {
                sb.append(i+ " ");
            }
        }
        if (sb.length() <= 0) {
            System.out.println("HE GOT AWAY!");
        }
        else {
            System.out.println(sb.toString());
        }

    }
}
