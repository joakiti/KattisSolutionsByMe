import java.util.ArrayList;
import java.util.Scanner;

public class TransitWoes {

    static String test = "0 10 1\n" +
            "3 3\n" +
            "1\n" +
            "8";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int n = scanner.nextInt();

        ArrayList<Integer> walktimes = new ArrayList<>();
        ArrayList<Integer> ridingTime = new ArrayList<>();
        ArrayList<Integer> destinationIntervals = new ArrayList<>();
        for (int i = 0; i < n + 1 ; i++) {
            walktimes.add(scanner.nextInt());
        }
        for (int j = 0; j < n; j++) {
            ridingTime.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            destinationIntervals.add(scanner.nextInt());
        }
        int travelTime = s;
        for (int i = 0; i < n; i++) {
            travelTime += walktimes.get(i); //Walk to the bus
            travelTime += travelTime % destinationIntervals.get(i); //Wait for the bus to arrive
            travelTime += ridingTime.get(i); //Ride it
        }
        travelTime += walktimes.get(walktimes.size() - 1 );
        if (travelTime < t) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
