import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HangMa {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String word = s.next();
        String alphabet = s.next();
        List<Character> individualWord = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int lives = 10;
        for (int i = 0; i < alphabet.length(); i++) {
            if (individualWord.contains(alphabet.charAt(i))) {
                individualWord.removeAll(List.of(alphabet.charAt(i)));
            } else {
                lives--;
            }
            if (individualWord.size() == 0) {
                System.out.println("WIN");
                System.exit(0);

            }
            if (lives == 0) {
                System.out.println("LOSE");
                System.exit(0);
            }

        }
    }
}
