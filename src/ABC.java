import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class ABC {

    static String test = "6 4 2\n" +
            "CAB\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        HashMap<Character, Integer> characterMap = new HashMap<>();
        final char[] A = {'A'};
        Stream.of(a,b,c).sorted().forEach(integer ->  {
            characterMap.put(A[0], integer);
            A[0]++;
        });
        String order = s.next();
        for (char ch :
                order.toCharArray()) {
            System.out.printf(characterMap.get(ch) + " ");
        }


    }
}
