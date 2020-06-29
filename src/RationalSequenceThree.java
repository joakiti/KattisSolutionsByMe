import java.util.LinkedList;
import java.util.Scanner;

public class RationalSequenceThree {

    static String test = "1\n" +
            "3 1431655765\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(test);

        Node root = new Node(1L, 1L);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            s.nextInt();
            long target = s.nextLong();
            System.out.println(i + " " + find_fraction(target, root));
        }

    }

    static Node find_fraction(long target, Node root) {
        int bin = 0, start = 0;
        while (target != 1) { //Compute height
            if (target % 2 == 1) {
                bin += Math.pow(2,start);
                System.out.println("bin = " + bin + ", target = " + target);
            }
            start++;
            target >>= 1; // half the height
        }
        for (int i = start - 1; i >= 0; i--) {
            System.out.println(Math.pow(2,i));
            if ((bin & (int) Math.pow(2,i)) != 0) root = new Node(root.p + root.q, root.q);
            else root = new Node(root.p, root.q + root.p);
        }
        return root;
    }
}

class Node {
    long p;
    long q;

    public Node(long p, long q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", p, q);
    }


}
