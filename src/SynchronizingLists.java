import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SynchronizingLists {

    static String test = "4\n" +
            "10\n" +
            "67\n" +
            "68\n" +
            "28\n" +
            "55\n" +
            "73\n" +
            "10\n" +
            "6\n" +
            "7\n" +
            "98\n" +
            "23\n" +
            "61\n" +
            "49\n" +
            "1\n" +
            "79\n" +
            "9\n" +
            "1\n" +
            "15\n" +
            "32\n" +
            "47\n" +
            "68\n" +
            "39\n" +
            "24\n" +
            "0";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        int n = s.nextInt();

        while (true) {
            int[] first = new int[n], second = new int[n];

            HashMap<Integer, Integer> indexArrayFirst = new HashMap<>();


            for (int i = 0; i < n; i++) {
                int next = s.nextInt();
                first[i] = next;
                indexArrayFirst.put(next, i);
            }

            for (int i = 0; i < n; i++) {
                second[i] = s.nextInt();
            }
            Arrays.sort(first);
            Arrays.sort(second);
            int[] solution = new int[n];
            for (int i = 0; i < n; i++) {
                solution[indexArrayFirst.get(first[i])] = second[i];
            }
            for (int i = 0; i < n; i++) {
                System.out.println(solution[i]);
            }

            n = s.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println();
        }
    }
}
