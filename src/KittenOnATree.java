import java.util.Scanner;

public class KittenOnATree {

    static String test = "14\n" +
            "25 24\n" +
            "4 3 1 2\n" +
            "13 9 4 11\n" +
            "10 20 8 7\n" +
            "32 10 21\n" +
            "23 13 19 32 22\n" +
            "19 12 5 14 17 30\n" +
            "14 6 15 16\n" +
            "30 18 31 29\n" +
            "24 23 26\n" +
            "26 27 28\n" +
            "-1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] tree = new int[101];

        int pos = s.nextInt();
        s.nextLine();
        while (true) {
            String[] numbers = s.nextLine().split(" ");
            int index = Integer.parseInt(numbers[0]);
            if (index == -1) {
                break;
            }
            for (int i = 1; i < numbers.length; i++) {
                tree[Integer.parseInt(numbers[i])] = index;
            }
        }
        while (pos != 0) {
            System.out.print(pos+" ");
            pos = tree[pos];
        }
    }
}
