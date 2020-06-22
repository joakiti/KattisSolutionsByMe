import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FallingApart {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        ArrayList<Integer> problems = new ArrayList<>();
        while (n-- != 0) {
            problems.add(s.nextInt());
        }
        problems.sort(Comparator.reverseOrder());
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < problems.size(); i++) {
            if (i % 2 == 0) {
                alice += problems.get(i);
            }
            else {
                bob += problems.get(i);
            }
        }
        System.out.printf("%d %d", alice, bob);
    }
}
