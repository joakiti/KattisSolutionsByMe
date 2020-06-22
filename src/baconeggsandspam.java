import java.util.*;
import java.util.stream.Collectors;

public class baconeggsandspam {

    static String test = "3\n" +
            "Alice bacon eggs spam\n" +
            "Sue pancakes sausage ham\n" +
            "David eggs spam\n" +
            "1\n" +
            "Bill diet-coke\n" +
            "0\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int n = s.nextInt();
            s.nextLine();
            if (n == 0) {
                System.exit(0);
            }
            HashMap<String, ArrayList<String>> orders = new HashMap<>();

            while (n-- != 0) {
                String[] orderAndName = s.nextLine().split(" ");
                String name = orderAndName[0];
                for (int i = 1; i < orderAndName.length ; i++) {
                    ArrayList<String> add =  orders.getOrDefault(orderAndName[i], new ArrayList<>());
                    add.add(name);
                    orders.put(orderAndName[i], add);
                }
            }
            Set<Map.Entry<String, ArrayList<String>>> keyValue = orders.entrySet();
            List<Map.Entry<String, ArrayList<String>>> answer = keyValue.stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toCollection(ArrayList::new));
            for (Map.Entry<String, ArrayList<String>> ans :
                    answer) {
                System.out.print(ans.getKey() + " ");
                ans.getValue().sort(String::compareTo);
                for (String b : ans.getValue()) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
