import java.util.Scanner;

public class LineU {

    static String test = "4\n" +
            "D\n" +
            "CA\n" +
            "CB\n" +
            "A";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Boolean isIncreasing = null;
        String[] names = new String[n];
        String last = s.next();
        for (int i = 1; i < n; i++) {
            String curr = s.next();
            if (isIncreasing == null) {
                isIncreasing = curr.compareTo(last) > 0;
                last = curr;
            }
            else {
                if ((curr.compareTo(last) > 0 && !isIncreasing) || (curr.compareTo(last) < 0 && isIncreasing)) {
                    System.out.println("NEITHER");
                    System.exit(0);
                }
                last = curr;
            }
        }
        if (isIncreasing) {
            System.out.println("INCREASING");
        }
        else {
            System.out.println("DECREASING");
        }
    }
}
