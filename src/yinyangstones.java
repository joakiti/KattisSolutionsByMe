import java.util.Scanner;

public class yinyangstones {
    static String test = "WWBWBB\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String line = s.nextLine();
        int whites = 0;
        int blacks = 0;
        for (char c :
                line.toCharArray()) {
            if (c == 'W') {
                whites++;
            }
            else {
                blacks++;
            }
        }
        if (Math.abs(whites-blacks) == 0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
