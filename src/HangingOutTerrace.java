import java.util.Scanner;

public class HangingOutTerrace {

    static String test = "4 5\n" +
            "enter 3\n" +
            "enter 2\n" +
            "leave 1\n" +
            "enter 1\n" +
            "enter 2";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int groupLimit = s.nextInt();
        int n = s.nextInt();
        int runningTotal = 0;

        int denied = 0;
        while (n-- != 0) {
            String command = s.next();
            int groupMembers = s.nextInt();
            if (command.equals("enter") && groupLimit < runningTotal + groupMembers) {
                denied++;
            } else if (command.equals("enter")) {
                runningTotal += groupMembers;

            }
            else {
                runningTotal -= groupMembers;
            }
        }
        System.out.println(denied);
    }
}
