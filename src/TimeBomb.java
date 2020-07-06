import java.util.Scanner;

public class TimeBomb {

    static String test =
            "***   * * * *** *** *** ***\n" +
                    "* *   * * *   *   *   * *  \n" +
                    "* *   * *** *** *** *** ***\n" +
                    "* *   *   * *     * *   * *\n" +
                    "***   *   * *** *** *** ***\n";

    static int getNumb(char[][] digits, int startFrom) {
        StringBuilder l1 = new StringBuilder();
        StringBuilder l2 = new StringBuilder();
        StringBuilder l3 = new StringBuilder();
        StringBuilder l4 = new StringBuilder();
        StringBuilder l5 = new StringBuilder();

        for (int i = startFrom; i < startFrom + 3; i++) { // a digit fills 3 characters
            l1.append(digits[i][0]);
            l2.append(digits[i][1]);
            l3.append(digits[i][2]);
            l4.append(digits[i][3]);
            l5.append(digits[i][4]);
        }

        if (l1.toString().equals("***") &&
                l2.toString().equals("* *") &&
                l3.toString().equals("* *") &&
                l4.toString().equals("* *") &&
                l5.toString().equals("***")) {
            return 0;
        }
        if (l1.toString().equals("  *") &&
                l2.toString().equals("  *") &&
                l3.toString().equals("  *") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("  *")) {
            return 1;
        }
        if (l1.toString().equals("* *") &&
                l2.toString().equals("* *") &&
                l3.toString().equals("***") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("  *")) {
            return 4;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("  *") &&
                l3.toString().equals("***") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("***")) {
            return 3;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("  *") &&
                l3.toString().equals("***") &&
                l4.toString().equals("*  ") &&
                l5.toString().equals("***")) {
            return 2;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("*  ") &&
                l3.toString().equals("***") &&
                l4.toString().equals("* *") &&
                l5.toString().equals("***")) {
            return 6;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("*  ") &&
                l3.toString().equals("***") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("***")) {
            return 5;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("  *") &&
                l3.toString().equals("  *") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("  *")) {
            return 7;
        }

        if (l1.toString().equals("***") &&
                l2.toString().equals("* *") &&
                l3.toString().equals("***") &&
                l4.toString().equals("* *") &&
                l5.toString().equals("***")) {
            return 8;
        }
        if (l1.toString().equals("***") &&
                l2.toString().equals("* *") &&
                l3.toString().equals("***") &&
                l4.toString().equals("  *") &&
                l5.toString().equals("***")) {
            return 9;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String v = s.nextLine();

        char[][] digits = new char[v.length()][5]; // always 5 height
        for (int j = 0; j < v.length(); j++) {
            digits[j][0] = v.charAt(j);
        }
        for (int i = 1; i < 5; i++) {
            v = s.nextLine();
            for (int j = 0; j < v.length(); j++) {
                digits[j][i] = v.charAt(j);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < v.length(); i += 4) {
            int numb = getNumb(digits, i);
            if (numb == -1) {
                System.out.println("BOOM!!");
                System.exit(0);
            } else {
               ans.append(numb);
            }
        }
        int answer = Integer.parseInt(ans.toString());
        if (answer % 6 == 0) {
            System.out.println("BEER!!");
        }
        else {
            System.out.println("BOOM!!");
        }
    }
}
