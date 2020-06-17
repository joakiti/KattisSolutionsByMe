import java.util.*;

public class Autori {

    static String test = "Knuth-Morris-Pratt\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        String k = s.nextLine();

        StringBuilder sb = new StringBuilder();
        String[] names = k.split("-");

        for(String n : names) {
            sb.append(n.charAt(0));
        }
        System.out.println(sb.toString());

    }
}