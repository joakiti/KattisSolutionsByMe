import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Veci {


    static String test = "230";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String number = s.next();
        boolean isSortedDescending = true;
        boolean isSortedAscending = true;

        char upper = number.toCharArray()[0];
        char lower = number.toCharArray()[0];

        for (char c : number.toCharArray()) {
            if (upper < c) {
                isSortedDescending = false;
            }
            if (lower > c) {
                isSortedAscending = false;
            }
            upper = c;
            lower = c;
        }
        if (isSortedDescending) {
            System.out.println(0);
            System.exit(0);
        }
        else if (isSortedAscending) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length() - 2; i++) {
                sb.append(number.charAt(i));
            }
            sb.append(number.charAt(number.length() - 1));
            sb.append(number.charAt(number.length() - 2));
            System.out.println(sb.toString());
            System.exit(0);
        }
        else {
            int first = Integer.MIN_VALUE;
            int firstIndex = -1;
            for (int i = number.length() - 1; i >= 0; i--) {
                if (number.charAt(i) < first) {
                    first = number.charAt(i);
                    firstIndex = i;
                    break;
                }
                first = number.charAt(i);
            }
            int second = Integer.MAX_VALUE;
            int secondIndex = -1;
            for (int i = firstIndex; i < number.length(); i++) {
                if (first < number.charAt(i)) {
                    second = Math.min(second, number.charAt(i));
                    secondIndex = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(number.substring(0, firstIndex));
            sb.append(number.charAt(secondIndex));
            sb.append(number.substring(firstIndex + 1, secondIndex));
            sb.append(number.charAt(firstIndex));
            sb.append(number.substring(secondIndex + 1));
            String rest = sb.toString().substring(firstIndex + 1);
            List<Integer> numbersInRest = new ArrayList<>();
            for (char c :
                    rest.toCharArray()) {
                numbersInRest.add(Integer.parseInt(String.valueOf(c)));
            }
            numbersInRest.sort(Integer::compareTo);
            StringBuilder numbersSb = new StringBuilder();
            for (Integer i :
                    numbersInRest) {
                numbersSb.append(i);
            }
            System.out.println(sb.substring(0, firstIndex + 1) + numbersSb.toString());
        }

    }
}
