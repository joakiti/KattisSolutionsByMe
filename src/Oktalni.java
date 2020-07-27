import java.util.Scanner;

public class Oktalni {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String binary = s.next();
        System.out.println(Integer.toOctalString(Integer.parseInt(binary, 2)));
    }
}
