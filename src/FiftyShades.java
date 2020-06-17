import java.util.Scanner;

public class FiftyShades {

    static String test = "12\n" +
            "pink\n" +
            "tequilaSunrose\n" +
            "mExicanPInK\n" +
            "Coquelicot\n" +
            "turqrose\n" +
            "roSee\n" +
            "JETblack\n" +
            "pink\n" +
            "babypink\n" +
            "pInKpinkPinK\n" +
            "PInkrose\n" +
            "lazerlemon";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int noOfButtons = 0;
        while (n-- != 0) {
            String b = s.next().toLowerCase();
            if (b.contains("pink") || b.contains("rose")) {
                noOfButtons++;
            }
        }
        if (noOfButtons == 0) {
            System.out.println("I must watch Star Wars with my daughter\n");
        }
        else {
            System.out.println(noOfButtons);
        }
    }
}
