import java.util.Scanner;

public class Gerrymandering {

    static String test = "5 3\n" +
            "1 100 200\n" +
            "2 100 99\n" +
            "3 100 50\n" +
            "3 100 50\n" +
            "2 100 98";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int P = s.nextInt();
        int D = s.nextInt();

        int[] A = new int[D];
        int[] B = new int[D];

        int totalA = 0;
        int totalB = 0;
        int totalVotes = 0;

        while (P-- != 0) {
            int d = s.nextInt() - 1;
            A[d] += s.nextInt();
            B[d] += s.nextInt();
        }
        for (int i = 0; i < D; i++) {
            int total = A[i] + B[i];
            totalVotes += total;
            char winner = A[i] > B[i] ? 'A' : 'B';
            int wastedA = winner == 'A' ? A[i] - (total/2 + 1) : A[i];
            int wastedB = winner == 'B' ? B[i] - (total/2 + 1) : B[i];
            totalA += wastedA;
            totalB += wastedB;
            System.out.println(winner + " " + wastedA + " " + wastedB);
        }
        System.out.println(Math.abs(totalA - totalB)/(double)totalVotes);
    }
}
