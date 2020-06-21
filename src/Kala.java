import java.util.ArrayList;
import java.util.Scanner;

public class Kala {

    static String test = "4 5\n" +
            "adaca\n" +
            "da##b\n" +
            "abb#b\n" +
            "abbac";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        char[][] crossword = new char[r][c];
        for (int i = 0; i < r; i++) {
            crossword[i] = s.next().toCharArray();
        }
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            StringBuilder wordBuilder = new StringBuilder();
            for (int j = 0; j < c; j++) {
                char letter = crossword[i][j];
                if (letter == '#') {
                    if (wordBuilder.toString().length() > 1) {
                        words.add(wordBuilder.toString());
                    }
                    wordBuilder = new StringBuilder();
                    continue;
                }
                wordBuilder.append(letter);
            }
            if (wordBuilder.toString().length() > 1) {
                words.add(wordBuilder.toString());
            }
        }
        for (int i = 0; i < c; i++) {
            StringBuilder wordBuilder = new StringBuilder();
            for (int j = 0; j < r; j++) {
                char letter = crossword[j][i];
                if (letter == '#') {
                    if (wordBuilder.toString().length() > 1) {
                        words.add(wordBuilder.toString());
                    }
                    wordBuilder = new StringBuilder();
                    continue;
                }
                wordBuilder.append(letter);
            }
            if (wordBuilder.toString().length() > 1) {
                words.add(wordBuilder.toString());
            }
        }
        words.sort(String::compareTo);
        System.out.println(words.get(0));



   }
}
