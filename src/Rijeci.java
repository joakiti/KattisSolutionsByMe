import java.util.Scanner;

public class Rijeci {

    static String test = "10";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int iterations = s.nextInt();

        int numbersOfA = 1;
        int numbersOfB = 0;

        numbersOfB = fibSequence(0, 1, iterations, 0);
        numbersOfA = fibSequence(0, 1 , iterations-1, 0);


        System.out.println(numbersOfA);
        System.out.println(numbersOfB);


    }

    private static int fibSequence(int i, int i1, int i2, int current) {
        if (i2 == current) {
            return i;
        }
        else {
            return fibSequence(i1, i+i1, i2, current+1);
        }
    }
}
