import java.util.Scanner;

public class KeyToCryptography {

    static String test = "SGZVQBUQAFRWSLC\n" +
            "ACM\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String encrypted = s.next();
        String key = s.next();
        char[] solution = new char[encrypted.length() + key.length()];
        for (int i = 0; i < key.length(); i++) {
            solution[i] = key.charAt(i);
        }
        for (int i = 0; i < encrypted.length(); i++) {
            int c = encrypted.charAt(i) - 'A';
            int b = solution[i] - 'A';
            int difference = c - b;
            solution[key.length() + i] = (char) ('A' + ((26 + difference) % 26));
        }
        for (int i = key.length(); i < encrypted.length() + key.length(); i++) {
            System.out.printf("%c", solution[i]);
        }

    }
}
