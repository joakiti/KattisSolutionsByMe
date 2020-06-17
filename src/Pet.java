import java.util.ArrayList;
import java.util.Scanner;

public class Pet {
static String test = "5 4 4 5\n" +
        "5 4 4 4\n" +
        "5 5 4 4\n" +
        "5 5 5 4\n" +
        "4 4 4 5";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        ArrayList<Integer> contestsants = new ArrayList<>();
        for (int i =1 ; i <= 5; i++) {
            contestsants.add(s.nextInt() + s.nextInt() + s.nextInt() + s.nextInt());
        }
        System.out.println(contestsants.indexOf(contestsants.stream().max(Integer::compareTo).get()) + 1 + " " +contestsants.stream().max(Integer::compareTo).get());
    }
}
