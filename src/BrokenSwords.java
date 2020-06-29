import java.util.LinkedList;
import java.util.Scanner;

public class BrokenSwords {

    static String test = "4\n" +
            "0100\n" +
            "0010\n" +
            "0110\n" +
            "1010\n";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        LinkedList<Boolean> topOrDown = new LinkedList<>();
        LinkedList<Boolean> leftOrRight = new LinkedList<>();

        while (n-- != 0) {
            char[] l = s.next().toCharArray();
            for (int i = 0; i < l.length; i++) {
                if (l[i] == '0' && i < 2) {
                    topOrDown.add(true);
                }
                else if (l[i] == '0') {
                    leftOrRight.add(true);
                }
            }
        }
        int canBuildFromTopDown = topOrDown.size()/2;
        int canBuildFromLeftRight = leftOrRight.size()/2;
        int canBuildTotal = Math.min(canBuildFromLeftRight, canBuildFromTopDown);
        System.out.print(canBuildTotal + " ");
        System.out.print(topOrDown.size() - canBuildTotal*2 + " ");
        System.out.print(leftOrRight.size() - canBuildTotal*2);

    }

}

