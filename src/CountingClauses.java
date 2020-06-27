import java.util.Scanner;

public class CountingClauses {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int noClauses = s.nextInt();

        if (noClauses < 8) {
            System.out.println("unsatisfactory");
        }
        else {
            System.out.println("satisfactory");
        }
    }
}
