import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EenyMeeny {

    static String test = "eeny meeny miny\n" +
            "4\n" +
            "Kalle\n" +
            "Lisa\n" +
            "Alvar\n" +
            "Rakel\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] rhyme = s.nextLine().split(" ");

        int kids = s.nextInt();
        ArrayList<String> theirNames = new ArrayList<>();
        for (int i = 0; i < kids; i++) {
            theirNames.add(s.next());
        }
        int start = 0;
        ArrayList<String> teamOne = new ArrayList<>();
        ArrayList<String> teamTwo = new ArrayList<>();
        int count = rhyme.length - 1;
        boolean addToTeamOne = true;
        while (!theirNames.isEmpty()) {
            start += count;
            start %= theirNames.size();
            if (addToTeamOne) {
                teamOne.add(theirNames.remove(start));
                addToTeamOne = false;
            } else {
                teamTwo.add(theirNames.remove(start));
                addToTeamOne = true;
            }
        }
        System.out.println(teamOne.size());
        for (int i = 0; i < teamOne.size(); i++) {
            System.out.println(teamOne.get(i));
        }
        System.out.println(teamTwo.size());
        for (int i = 0; i < teamTwo.size(); i++) {
            System.out.println(teamTwo.get(i));
        }
    }
}
