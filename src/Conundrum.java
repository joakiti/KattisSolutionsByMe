import java.util.Scanner;

public class Conundrum {

    static String test = "SECRET";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String cipher = s.next();

        int days = 0;
        for (int i = 0; i < cipher.length(); i+=3) {
            if (cipher.charAt(i) != 'P') {
                days++;
            }
            if (cipher.charAt(i+1) != 'E'){
                days++;
            }
            if (cipher.charAt(i+2) != 'R') {
                days++;
            }
        }
        System.out.println(days);
    }
}
