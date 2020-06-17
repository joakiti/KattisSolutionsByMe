import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

public class TenKindsOfPeople {
    public static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();
        char[][] map = new char[rows][cols];
        s.nextLine();

        for (int i = 0; i < rows; i++) {
            map[i] = s.nextLine().toCharArray();
        }
        int[][] grouped = createGroups(map);

        int tests = s.nextInt();
        for (int i = 0; i < tests; i++) {
            int y1 = s.nextInt()-1;
            int x1 = s.nextInt()-1;
            int y2 = s.nextInt()-1;
            int x2 = s.nextInt()-1;
            if (grouped[y1][x1] == grouped[y2][x2]) {
                System.out.println((map[y1][x1] == '0' ? "binary" : "decimal"));
            }
            else {
                System.out.println("neither");
            }
        }

    }

    private static int[][] createGroups(char[][] map) {
        int[][] numberToGroup = new int[map.length][map[0].length];
        int groupNo = 1; //Currently, all indexes map to 0. We want to use 0 for saying that a position has not been visited
        char currentType;
        for (int x = 0; x < map[0].length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (numberToGroup[y][x] > 0) {
                    continue;
                }
                currentType = map[y][x];
                numberToGroup[y][x] = groupNo;
                LinkedList<Point> coordinates = new LinkedList<>();
                coordinates.push(new Point(x,y));

                while (!coordinates.isEmpty()) {
                    Point currentPoint = coordinates.poll();
                    /**
                     * Spread out from origin point
                     */
                    for (int i = 0; i < directions.length; i++) {
                        Point newCoords = new Point(currentPoint.x + directions[i][0], currentPoint.y + directions[i][1]);
                        if (newCoords.x < map[0].length && newCoords.y < map.length && newCoords.x >= 0 && newCoords.y >= 0) {
                            if ((numberToGroup[newCoords.y][newCoords.x] < 1) && map[newCoords.y][newCoords.x] == currentType) {
                                //Have not been marked, and is same type
                                numberToGroup[newCoords.y][newCoords.x] = groupNo; // add to our group
                                coordinates.push(newCoords);
                            }
                        }
                    }
                }
                groupNo++;
            }
        }
        return numberToGroup;
    }
}