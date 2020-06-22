import java.util.Scanner;

public class Volim {

    static String test = "5\n" +
            "6\n" +
            "70 T\n" +
            "50 P\n" +
            "30 N\n" +
            "50 T\n" +
            "30 P\n" +
            "80 T\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int index = s.nextInt() - 1;
        int questions  = s.nextInt();
        int participants = 8;
        int time = 0;
        int timeLimit = 210;
        for (int i = 0; i < questions; i++) {
            time += s.nextInt();
            if (time >= timeLimit) {
                System.out.println(index + 1);
                System.exit(0);
            }
            if (s.next().charAt(0) == 'T') {
                index = (index + 1) % participants;
            }
        }
        
    }
}
