import java.util.Scanner;

public class ColdputerScience {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testcases = s.nextInt();
        int total = 0;
        while (testcases-- != 0) {
            if (s.nextInt() < 0) {
                total ++;
            }
        }
        System.out.println(total);
    }
}
