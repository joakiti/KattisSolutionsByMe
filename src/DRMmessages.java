import java.util.Scanner;

public class DRMmessages {

    static String test = "EWPGAJRB\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String cipher = s.next();

        char[] a = cipher.substring(0, cipher.length()/2).toCharArray();
        char[] b = cipher.substring(cipher.length()/2).toCharArray();

        int sumA = 0;
        int sumB = 0;
        for (char c: a) sumA += c - 'A';
        for (char c: b) sumB += c - 'A';

        for (int i = 0; i < a.length; i++) {
            a[i] = (char) ('A' + ((a[i] - 'A' + sumA) % 26));
            b[i] = (char) ('A' + ((b[i] - 'A' + sumB) % 26));
            a[i] = (char) ('A' + ((a[i] -'A' + (b[i] - 'A')) % 26));
            System.out.printf("%c", a[i]);
        }




    }
}
