import java.util.Scanner;

public class HelpAPhd {

    static String test = "4\n" +
            "2+1232\n" +
            "1+2\n" +
            "P=NP\n" +
            "0+0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        while (n-- != 0) {
            String addition = s.next();
            if (addition.contains("P=NP")) {
                System.out.println("skipped");
            }
            else {
                String[] ints = addition.split("\\+");
                int added = Integer.parseInt(ints[0]) + Integer.parseInt(ints[1]);
                System.out.println(added);
            }
        }
    }
}
