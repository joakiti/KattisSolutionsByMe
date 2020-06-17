import java.util.Scanner;

public class JudgingMoose {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        if (a == 0 && b == 0) {
            System.out.println("Not a moose");
        }
        else if (a == b) {
            System.out.println("Even " +a*2);
        }
        else {
            System.out.println("Odd " + Math.max(a,b)*2);
        }
    }
}
