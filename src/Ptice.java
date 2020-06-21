import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ptice {
    static String test = "5\n" +
            "BAACC";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        s.next();

        int adrian = 0;
        int bruno = 0;
        int goran = 0;

        List<Character> adrianSequence = List.of('A', 'B', 'C');
        List<Character> brunoSequence = List.of('B', 'A', 'B', 'C');
        List<Character> goranSequence = List.of('C', 'C', 'A', 'A', 'B', 'B');

        String code = s.next();
        int index = 0;
        for (char c : code.toCharArray()) {
            if (adrianSequence.get(index % 3) == c) {
                adrian++;
            }
            if (brunoSequence.get(index % 4) == c) {
                bruno ++;
            }
            if (goranSequence.get(index % 6) == c) {
                goran++;
            }
            index++;
        }
        int winner = Math.max(adrian, Math.max(bruno, goran));
        System.out.println(winner);
        if (adrian == winner) {
            System.out.println("Adrian");
        }
        if (bruno == winner) {
            System.out.println("Bruno");
        }
        if (goran == winner) {
            System.out.println("Goran");
        }


    }
}
