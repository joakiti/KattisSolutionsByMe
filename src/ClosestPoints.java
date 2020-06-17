import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ClosestPoints {

    static String filename = "kattis";

    public static void main(String[] args) {
        List<Coords> points = parseInputFiles();
        double min = closestPoints(points);
        System.out.println(min);
    }

    private static void prepareKattis() {
        Scanner s = new Scanner(System.in);
        int numberOfPoints = s.nextInt();
        parseKattisInput(numberOfPoints, s);
    }

    private static void parseKattisInput(int numberOfCases, Scanner s) {
        List<Coords> points = new ArrayList<>();
        for (int i = 0; i < numberOfCases; i++) {
            points.add(new Coords(s.nextFloat(), s.nextFloat(), "KATTIS"));
        }

        if (points.size() == 0) {
            System.err.println("ERROR: Missing values");
            System.exit(-1);
        }
        PairOfCoords min = closestPointsCoords(points);
        System.out.println(min.p1.x + " " + min.p1.y + " " + min.p2.x + " " + min.p2.y);
        if (s.hasNext()) {
            int nextCases = s.nextInt();
            if (nextCases != 0) {
                parseKattisInput(nextCases, s);
            }

        }
    }


    private static List<Coords> parseInputFiles() {
        Scanner s = null;
        try {
            s = new Scanner(new File("C:\\Users\\Mikkel\\Desktop\\CS_ITU\\AlgorithmDesign\\algdes-labs\\closest-points\\data\\wc-instance-65534.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Pattern regex = Pattern.compile("(?<id>[0-9\\w]+)\\s+(?<x>[\\d.\\-+e]+)\\s+(?<y>[\\d.\\-+e]+)");
        List<Coords> points = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            Matcher match = regex.matcher(line);
            if (match.find()) {

                points.add(new Coords(Float.parseFloat(match.group("x")), Float.parseFloat(match.group("y")), match.group("id")));
            }
        }
        if (points.size() == 0) {
            System.err.println("ERROR: Missing values");
            System.exit(-1);
        }
        return points;
    }

    private static PairOfCoords closestPointsCoords(List<Coords> points) {
        List<Coords> sortedByX = sortByX(points);
        return closestPairRec(sortedByX);
    }

    private static double closestPoints(List<Coords> points) {
        List<Coords> sortedByX = sortByX(points);
        PairOfCoords closestPair = closestPairRec(sortedByX);
        return Math.sqrt(closestPair.distance);
    }

    private static PairOfCoords closestPairRec(List<Coords> sortedByX) {
        if (sortedByX.size() <= 3) {
            return bruteForceNSquared(sortedByX);
        }

        int median = sortedByX.size()/2;
        int size = sortedByX.size();
        //Dividing the input into two halves we have qx consisting of all points in increasing x from index 0 to size/2.
        List<Coords> qx = sortedByX.subList(0, median);
        //Dividing the input into the second half we have rx consisting of all points in increasing x from index size/2+1 to size.
        List<Coords> rx = sortedByX.subList(size-median, sortedByX.size());

        //We divide and conquer, splitting the input in half once again.
        PairOfCoords leftDistance = closestPairRec(qx);
        PairOfCoords rightDistance = closestPairRec(rx);

        //We now take the minimum distance of the two distances found in the two planes.
        PairOfCoords minDistance = leftDistance.distance > rightDistance.distance ? rightDistance : leftDistance;

        //In this method, for the two divided planes, we
        //List<Coords> Sy = sortByY(createPointsCloseToSplit(qx, rx, Math.sqrt(minDistance.distance)));

        List<Coords> Sy = sortByY(createPointsCloseToSplit(qx, rx, Math.sqrt(minDistance.distance)));

        //We check the seven next pairs, as there can only be seven candidates within the radius of delta.
        int comparisons = Sy.size() > 7 ? 7 : Sy.size() - 1;

        for (int i = 0; i < Sy.size(); i++) {
            Coords current = Sy.get(i);
            if (Sy.size() - 1 - i < comparisons) {
                comparisons = comparisons - 1;
            }
            for (int g = 1; g <= comparisons; g++) {
                PairOfCoords distance = new PairOfCoords(current, Sy.get(i + g), current.quickButNotPreciseDistanceTo(Sy.get(i + g)));
                if (distance.distance < minDistance.distance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    private static List<Coords> createPointsCloseToSplit(List<Coords> qx, List<Coords> rx, double delta) {
        List<Coords> Sy = new ArrayList<>();
        int index = qx.size() - 1;
        int current = index;
        while (current >= 0 && Math.abs(qx.get(current).x - qx.get(index).x) < delta) {
            Sy.add(qx.get(current));
            current--;
        }
        current = 0;
        while (current < rx.size() && rx.get(current).x - qx.get(index).x < delta) {
            Sy.add(rx.get(current));
            current++;
        }
        return Sy;
    }

    private static List<Coords> copyBottomHalf(List<Coords> sortedBy) {
        List<Coords> x = new ArrayList<>(sortedBy.size() / 2);
        for (int i = 0; i < Math.floor(sortedBy.size() / 2); i++) {
            x.add(sortedBy.get(i));
        }
        return x;
    }

    private static List<Coords> copyTopHalf(List<Coords> sortedBy) {
        List<Coords> y = new ArrayList<>(sortedBy.size() / 2);
        for (int i = (int) Math.floor(sortedBy.size() / 2); i < sortedBy.size(); i++) {
            y.add(sortedBy.get(i));
        }
        return y;
    }

    private static PairOfCoords bruteForceNSquared(List<Coords> sortedByX) {
        //Instead of checking for null, we initialize minDistance to an insanely high distance, and expect that there should be an pair with smaller distance.
        PairOfCoords minDistance = PairOfCoords.emptyPairWithMaxDitance();
        for (int i = 0; i < sortedByX.size(); i++) {
            Coords current = sortedByX.get(i);
            for (int g = 0; g < sortedByX.size(); g++) {
                if (g == i) {
                    continue;
                }
                PairOfCoords distance = new PairOfCoords(current, sortedByX.get(g), current.quickButNotPreciseDistanceTo(sortedByX.get(g)));
                if (distance.distance < minDistance.distance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    private static List<Coords> sortByX(List<Coords> points) {
        ArrayList<Coords> cloned = new ArrayList<>(points);
        cloned.sort((o1, o2) -> {
            if (o1.x < o2.x) {
                return -1;
            } else if (o1.x > o2.x) {
                return 1;
            } else return 0;
        });
        return cloned;
    }

    private static List<Coords> sortByY(List<Coords> points) {
        ArrayList<Coords> cloned = new ArrayList<>(points);
        cloned.sort((o1, o2) -> {
            if (o1.y < o2.y) {
                return -1;
            } else if (o1.y > o2.y) {
                return 1;
            } else return 0;
        });
        return cloned;
    }
}

class PairOfCoords {
    final Coords p1;
    final Coords p2;
    final double distance;

    PairOfCoords(Coords pair1, Coords pair2, double distanceBetween) {
        this.p1 = pair1;
        this.p2 = pair2;
        this.distance = distanceBetween;
    }

    /**
     * We hide this constructor as it should not be used by anyone but the class
     *
     * @param distanceBetween
     */
    private PairOfCoords(double distanceBetween) {
        this.distance = distanceBetween;
        p1 = null;
        p2 = null;
    }

    static PairOfCoords emptyPairWithMaxDitance() {
        return new PairOfCoords(Double.MAX_VALUE);
    }


}

class Coords {
    final float x, y;
    String id;

    Coords(float tx, float ty, String id) {
        this.x = tx;
        this.y = ty;
        this.id = id;
    }

    public double euclideanDistanceTo(Coords p2) {
        return Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2));
    }

    public double quickButNotPreciseDistanceTo(Coords p2) {
        return this.x - p2.x * this.x - p2.x + Math.pow(this.y - p2.y, 2);
    }

    void setId(String id) {
        this.id = id;
    }
}