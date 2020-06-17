import java.util.Scanner;

public class QuickEstimates {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        while (n-- != 0 ) {
            String val = s.next();
            System.out.println(val.length());
        }
    }
}
