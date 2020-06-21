import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parkin {

    static String test = "5 3 1\n" +
            "1 6\n" +
            "3 5\n" +
            "2 8";
    ;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        int[] prices = new int[]{A, B, C};
        LinkedList<Integer> truckA = IntStream.rangeClosed(s.nextInt(), s.nextInt() - 1).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> truckB = IntStream.rangeClosed(s.nextInt(), s.nextInt() - 1).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> truckC = IntStream.rangeClosed(s.nextInt(), s.nextInt() - 1).boxed().collect(Collectors.toCollection(LinkedList::new));
        int price = 0;
        for (int i = 0; i < 100 && (!truckA.isEmpty() || !truckB.isEmpty() || !truckC.isEmpty()); i++) {
            int vehicles = 0;
            if (truckA.peek() != null && truckA.peek() == i) {
                truckA.poll();
                vehicles++;
            }
            if (truckB.peek() != null && truckB.peek() == i) {
                truckB.poll();
                vehicles++;
            }
            if (truckC.peek() != null && truckC.peek() == i) {
                truckC.poll();
                vehicles++;
            }
            price += vehicles * prices[vehicles - Math.min(vehicles, 1)];
        }
        System.out.println(price);
    }
}
