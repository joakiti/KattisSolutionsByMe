import java.util.Scanner;

public class Oddities {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        s.nextInt();
        while(s.hasNext()) {
            int c = s.nextInt();
            if (c % 2 == 0) {
                System.out.println(c + " is even");
            }
            else {
                System.out.println(c + " is odd");
            }
        }
    }
}
