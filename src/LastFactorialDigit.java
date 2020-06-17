import java.util.Scanner;

public class LastFactorialDigit {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        while (n-- != 0) {
            int i = s.nextInt();
            int solution = 1;
            for (int j = 1; j <= i; j++) {
                solution = (solution * j) % 10;
            }
            System.out.println(solution);
        }
    }
}
