import java.util.List;
import java.util.Scanner;

public class apaxianparent {

    static String test = "pamol toxes\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String y = s.next();
        String p = s.next();
        if (y.endsWith("e")) {
            System.out.println(y + "x" + p);
        }
        else if (List.of('a', 'u', 'i', 'o').contains(y.charAt(y.length() - 1))) {
            System.out.println(y.substring(0, y.length() - 1) + "ex" + p);
        }
        else if (y.endsWith("ex")) {
            System.out.println(y + p);
        }
        else {
            System.out.printf("%sex%s", y,p);
        }
    }
}
