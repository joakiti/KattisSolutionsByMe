import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PervasiveHeartMonitor {

    static String test = "Lisa Marie Presley 90.2 104.3 110.1 118.7 122.3\n" +
            "72.2 74 79.5 82.1 88.3 87.4 87.2 88.1 83.8 Bono\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, Double> nameToAverage = new HashMap<>();

        ArrayList<String> order = new ArrayList<>();

        while (s.hasNext()) {
            String data = s.nextLine();
            int readings = 0;
            double total = 0.;
            StringBuilder name = new StringBuilder();
            for (String a :
                    data.split(" ")) {
                try {
                    double reading = Double.parseDouble(a);
                    readings++;
                    total += reading;
                } catch (Exception e) {
                    name.append(a);
                    name.append(" ");
                }
            }
            nameToAverage.put(name.toString(), total / readings);
            order.add(name.toString());
        }
        for (String name :
                order) {
            System.out.println(nameToAverage.get(name) + " " + name);
        }
    }
}
