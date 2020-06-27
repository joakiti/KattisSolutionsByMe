import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class CompoundWords {

    static String test = "a bb\n" +
            "ab b\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        ArrayList<String> words = new ArrayList<>();
        while (s.hasNext()) {
            words.add(s.next());
        }
        words.sort(String::compareTo);
        TreeSet<String> ans = new TreeSet<>();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (j == i) {
                    continue;
                }
                ans.add(words.get(i)+words.get(j));
            }
        }
        for (String b :
                ans) {
            System.out.println(b);
        }
    }
}
