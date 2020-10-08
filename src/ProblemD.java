import java.util.Scanner;

public class ProblemD {

    static String test = "808\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        String input = s.next();

        while (input.length() > 1) {
            String[] toMultiply = input.split("");
            int nextInput = 1;
            for (String si : toMultiply) {
                if (!si.equals("0")) {
                    nextInput *= Integer.parseInt(si);
                }
            }
            input = String.valueOf(nextInput);
        }
        System.out.println(input);
    }
}
