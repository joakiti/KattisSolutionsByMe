import java.util.Scanner;

public class StarArrangements {

    static String test = "3";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int S = s.nextInt();
        System.out.println(S + ":");
        for (int i = 2; i < S; i++) {
            if (S % (i + i - 1) == 0 || (S - i) % (i + i - 1) == 0)  {
                System.out.println(i + "," + (i-1));
            }
            if (S % i == 0 ) {
                System.out.println(i + "," + i);
            }
        }
    }

}
