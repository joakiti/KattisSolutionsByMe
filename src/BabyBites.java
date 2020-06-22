import java.util.Scanner;

public class BabyBites {

    static String test = "5\n" +
            "1 2 3 mumble 5\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        String[] numbers = s.nextLine().split(" ");
        int current = 0;
        for (String v :
                numbers) {
            if (current == n) {
                System.out.println("something is fishy");
                System.exit(0);
            }
            try {
                int next = Integer.parseInt(v);
                if (Math.abs(next - current) != 1) {
                    System.out.println("something is fishy");
                    System.exit(0);
                }
                current = next;
            } catch (Exception e) { // it says mumble
                current++;
            }
        }
        if (current != n) {
            System.out.println("something is fishy");
        } else {
            System.out.println("makes sense");

        }

    }
}
