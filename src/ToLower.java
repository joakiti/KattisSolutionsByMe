import java.util.Scanner;

public class ToLower {

    static String test = "2 2\n" +
            "abc\n" +
            "Def\n" +
            "DDG\n" +
            "add\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int problems = s.nextInt();
        int count = 0;
        while (n-- > 0) {
            boolean allAreLower = true;
            for (int i = 0; i < problems; i++) {
                String test = s.next();
                test = test.substring(1);
                if (test.chars().sum() != test.toLowerCase().chars().sum()) {
                    allAreLower = false;
                }
            }
            if (allAreLower) {
                count++;
            }
        }
        System.out.println(count);
    }
}
