import java.util.Scanner;

public class NastyHacks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testcases = s.nextInt();

        while (testcases-- != 0) {
            int noAdvertising = s.nextInt();
            int advertising = s.nextInt();
            int priceOfAdvertising = s.nextInt();

            if (noAdvertising > advertising - priceOfAdvertising) {
                System.out.println("do not advertise");
            }
            else if (advertising - priceOfAdvertising > noAdvertising) {
                System.out.println("advertise");
            }
            else {
                System.out.println("does not matter");
            }
        }
    }
}
