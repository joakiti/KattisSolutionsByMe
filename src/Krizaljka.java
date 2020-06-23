import java.util.Scanner;

public class Krizaljka {

    static String test = "BANANA PIDZAMA\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String a = s.next();
        String b = s.next();

        char toUse = 0;
        for (char c :
                a.toCharArray()) {
            if (b.contains(String.valueOf(c))) {
                toUse = c;
                break;
            }
        }
        int columnNumberB = a.indexOf(toUse);
        int rowNumberA = b.indexOf(toUse);

        char[][] solution = new char[b.length()][a.length()];

        for (int i = 0; i < b.length(); i++) {
            solution[i][columnNumberB] = b.charAt(i);
        }
        for (int i = 0; i < a.length(); i++) {
            solution[rowNumberA][i] = a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (solution[i][j] == 0) {
                    System.out.print(".");
                }
                else {
                    System.out.print(solution[i][j]);
                }
            }
            System.out.println();
        }

    }
}
