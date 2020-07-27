import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class PaulEigon {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        long n = s.nextLong(), p = s.nextLong(), q = s.nextLong();
        BigInteger nBig = BigInteger.valueOf(n);
        BigInteger pBig = BigInteger.valueOf(p);
        BigInteger qBig = BigInteger.valueOf(q);
        BigInteger serves = pBig.add(qBig).divide(nBig);
        if (serves.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            System.out.println("paul");
        }
        else {
            System.out.println("opponent");
        }

    }
}
