import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {

    static String test = "5\n" +
            "3 1 10 5 15\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        BigInteger[] vals = new BigInteger [n];

        for (int i = 0; i < n; i++) {
            vals[i] = new BigInteger(s.next());
        }

        Arrays.sort(vals);
        for (int i = 0; i < vals.length; i++) {
            BigInteger  a = vals[i];
            for (int j = i + 1; j < vals.length; j++) {
                BigInteger  b = vals[j];
                int c = binarySearch(j + 1, vals, a.add(b));

                if (c < vals.length && vals[c].compareTo(a.add(b)) < 0) {
                    System.out.println("possible");
                    System.exit(0);
                }
                if (c + 1 < vals.length && vals[c + 1].compareTo(a.add(b)) < 0) {
                    System.out.println("possible");
                    System.exit(0);
                }
                if (c + 1 > 0 && c + 1 > j && vals[c - 1].compareTo(a.add(b)) < 0) {
                    System.out.println("possible");
                    System.exit(0);
                }
            }
        }
        System.out.println("impossible");
    }

    static int binarySearch(int bottom, BigInteger[] vals, BigInteger greaterThan) {
        int top = vals.length - 1;
        int lastindex = vals.length;
        while (top >= bottom) {
            int mid = bottom + (top-bottom)/2;
            if (vals[mid].compareTo(greaterThan) > 0) {
                top = mid - 1;
                lastindex = mid;
            }
            if (vals[mid].compareTo(greaterThan) == 0) {
                return mid;
            }
            else if (vals[mid].compareTo(greaterThan) < 0) {
                bottom = mid + 1;
                lastindex = mid;
            }
        }
        return lastindex;
    }
}
