import java.util.Scanner;

public class ZanziBar {

    static String test = "3\n" +
            "1 100 0\n" +
            "1 1 1 2 2 4 8 8 9 0\n" +
            "1 28 72 0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();

        while (testCases-- != 0) {
            int runningPopulation = 1;
            int result = 0;
            while (true) {
                int population = s.nextInt();
                if (population == 0) {
                    System.out.println(result);
                    break;
                }
                if (population > runningPopulation*2) {
                    result += population - 2*runningPopulation;
                }
                runningPopulation = population;
            }
        }
    }
}
