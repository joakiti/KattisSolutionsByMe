import java.util.Scanner;

public class Skener {

    static String test = "3 3 2 1\n" +
            ".x.\n" +
            "x.x\n" +
            ".x.";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();
        int repeatLine = s.nextInt();
        int repeatCharacter = s.nextInt();

        for (int i = 0; i < rows; i++) {
            String b = s.next();
            StringBuilder sb = new StringBuilder();
            for (char c :
                    b.toCharArray()) {
                for (int j = 0; j < repeatCharacter; j++) {
                    sb.append(c);
                }
            }
            for (int j = 0; j < repeatLine; j++) {
                System.out.println(sb.toString());
            }
        }
    }
}
