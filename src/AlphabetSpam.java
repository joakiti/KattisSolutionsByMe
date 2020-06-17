import java.util.Scanner;

public class AlphabetSpam {

    static String test = "Welcome_NWERC_participants!\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String line = s.next();

        int whitespace = 0;
        int lowercase = 0;
        int uppercase = 0;
        int symbols = 0;
        for (char c :
                line.toCharArray()) {
            if (c == '_') {
                whitespace++;
            }
            else if (c >= 'a' && c <= 'z') {
                lowercase++;
            }
            else if (c >= 'A' && c <= 'Z') {
                uppercase++;
            }
            else {
                symbols++;
            }
        }
        System.out.println(whitespace/ (double) line.length());
        System.out.println(lowercase/ (double) line.length());
        System.out.println(uppercase/ (double) line.length());
        System.out.println(symbols/(double) line.length());

    }
}
