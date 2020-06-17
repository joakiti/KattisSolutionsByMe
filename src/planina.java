import java.util.Scanner;

public class planina {

    static String test = "1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int iterations = s.nextInt();

        int columnLength = 2;
        for (int i = 1; i <= iterations ; i++) {
            columnLength += Math.pow(2, i-1);
        }

        System.out.println((int) Math.pow(columnLength, 2));
    }
}
