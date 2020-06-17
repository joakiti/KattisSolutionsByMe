import java.util.Scanner;

public class Cudoviste {

    static String test = "4 4\n" +
            "#..#\n" +
            "..X.\n" +
            "..X.\n" +
            "#XX#";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int p = s.nextInt();

        char[][] parking = new char[n][p];
        for (int i = 0; i < n; i++) {
                parking[i] = s.next().toCharArray();
        }
        int[] solution = new int[5];
        for (int j = 0; j < n - 1; j++) {
            for (int k = 0; k < p - 1; k++) {
                char a = parking[j][k];
                char b = parking[j+1][k];
                char c = parking[j][k+1];
                char d = parking[j+1][k+1];
                if (a == '#' || b == '#' || c == '#' || d == '#') {
                    continue;
                }
                int noOfCars = 0;
                if (a == 'X') noOfCars++;
                if (b == 'X') noOfCars++;
                if (c == 'X') noOfCars++;
                if (d == 'X') noOfCars++;
                solution[noOfCars]++;
            }
        }
        for (int i :
                solution) {
            System.out.println(i);
        }
    }
}
