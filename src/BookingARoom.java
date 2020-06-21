import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookingARoom {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int booked = s.nextInt();
        ArrayList<Integer>  bookedList = new ArrayList<>();
        ArrayList<Integer> availableRooms = IntStream.rangeClosed(1, r).boxed().collect(Collectors.toCollection(ArrayList::new));
        while (booked -- != 0) {
            bookedList.add(s.nextInt());
        }
        availableRooms.removeAll(bookedList);
        if (availableRooms.size() > 0) {
            System.out.println(availableRooms.get(0));
        }
        else {
            System.out.println("too late");
        }
    }
}
