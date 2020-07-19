import java.util.Arrays;
import java.util.Scanner;

public class Patulcji {

    static String test = "7\n" +
            "8\n" +
            "10\n" +
            "13\n" +
            "15\n" +
            "19\n" +
            "20\n" +
            "23\n" +
            "25\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = 9;
        int index = 0;
        int[] dwarfs = new int[9];
        while (--n >= 0) {
            dwarfs[index] = s.nextInt();
            index++;
        }
        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = i + 1; j < dwarfs.length; j++) {
                int finalI = i;
                int finalJ = j;
                int sum = Arrays.stream(dwarfs).filter(value -> value != dwarfs[finalI] && value != dwarfs[finalJ]).sum();
                if (sum == 100) {
                    Arrays.stream(dwarfs).filter(value -> value != dwarfs[finalI] && value != dwarfs[finalJ]).forEach(System.out::println);
                    System.exit(0);
                }
            }
        }
    }
}
