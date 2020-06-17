import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapTiles2 {

    static String test = "020";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String n = s.next();
        int zoomLevel = n.length();


        double amountOfTilesX = Math.pow(2, zoomLevel);
        double amountOfTilesY = Math.pow(2, zoomLevel);
        int x = 0;
        int y = 0;
        for (char c : n.toCharArray()) {
            if (c == '0') {
                amountOfTilesX /= 2;
                amountOfTilesY /= 2;
            } else if (c == '2') {
                amountOfTilesX /= 2;
                amountOfTilesY /= 2;
                y += amountOfTilesY;
            } else if (c == '3') {
                amountOfTilesX /= 2;
                amountOfTilesY /= 2;
                x += amountOfTilesX;
                y += amountOfTilesY;
            } else if (c == '1') {
                amountOfTilesX /= 2;
                amountOfTilesY /= 2;
                x += amountOfTilesX;
            }
        }
        System.out.print(zoomLevel + " " + x + " " + y);
        System.out.println();

    }


}
