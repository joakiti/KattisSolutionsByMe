import java.util.*;

public class NoDuplicates {

    static String test = "THE RAIN IN SPAIN\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String b = s.nextLine();
        List<String> values = Arrays.asList(b.split(" "));

        for (String v :
                values) {
            if (Collections.frequency(values, v) > 1) {
                System.out.println("no");
                System.exit(0);
            }
        }
        System.out.println("yes");
    }
}
