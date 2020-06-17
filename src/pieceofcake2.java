import java.util.Scanner;

public class pieceofcake2 {

    static String test = "4 2 1";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int widthOfCake = s.nextInt();

        int width = s.nextInt();
        int length = s.nextInt();

        int cakeOneVolume = width * length * 4;
        int cakeTwoVolume = (widthOfCake - width) * length * 4;
        int cakeThreeVolume = (widthOfCake - width) * (widthOfCake - length) * 4;
        int cakeFourVolume = (widthOfCake - length) * width * 4;

        System.out.println(Math.max(Math.max(Math.max(cakeOneVolume, cakeTwoVolume), cakeThreeVolume), cakeFourVolume));
    }
}
