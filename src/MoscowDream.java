import java.util.Scanner;

public class MoscowDream {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int n = s.nextInt();

        if (a+b+c < n || n < 3) {
            System.out.println("NO");
            System.exit(0);
        }
        else if (a == 0 || b == 0 || c == 0) {
            System.out.println("NO");
            System.exit(0);
        }
        else {
            System.out.println("YES");
        }
    }
}
