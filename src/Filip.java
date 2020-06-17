import java.util.Scanner;

public class Filip {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String a = s.next();
        String b = s.next();

        System.out.println(Math.max(Integer.parseInt(new StringBuilder(a).reverse().toString()), Integer.parseInt(new StringBuilder(b).reverse().toString())));
    }
}
