import java.util.Scanner;

public class Relocation {

    static String test = "5 10\n" +
            "5 2 8 1 4\n" +
            "1 2 10\n" +
            "2 4 5\n" +
            "2 1 3\n" +
            "1 4 3\n" +
            "2 1 5\n" +
            "2 5 2\n" +
            "1 4 1\n" +
            "2 2 4\n" +
            "1 3 15\n" +
            "2 4 1";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int noOfCompanies = s.nextInt();
        int q = s.nextInt();
        int[] companyLocations = new int[noOfCompanies + 1];

        for (int i = 1; i <= noOfCompanies; i++) {
            int companyNumber = s.nextInt();
            companyLocations[i] = companyNumber;
        }
        while (q-- != 0) {
            int query = s.nextInt();
            if (query == 1) {
                //company moves
                int company = s.nextInt();
                int destination = s.nextInt();
                companyLocations[company] = destination;
            }
            else if (query == 2) {
                System.out.println(Math.abs(companyLocations[s.nextInt()] - companyLocations[s.nextInt()]));
            }
        }
    }
}
