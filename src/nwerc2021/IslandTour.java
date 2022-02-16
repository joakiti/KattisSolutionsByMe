package nwerc2021;

import java.util.HashMap;
import java.util.Scanner;

public class IslandTour {

    static String testinput = "6\n" +
            "1 1 1 1 1 1\n" +
            "2 1 3 2 3 1\n" +
            "8 7 4 9 7 2\n" +
            "7 6 2 9 2 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(testinput);

        int n = s.nextInt();

        int x = 400000000;
        int[] travelTime = new int[n];
        for (int i = 0; i < n; i++) {
            travelTime[i] = s.nextInt();
        }

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];


        for (int i = 0; i < n; i++) {
            A[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = s.nextInt();
        }
        HashMap<Integer, int[]> persons = new HashMap<>();
        int personCount = 3;
        persons.put(0, A);
        persons.put(1, B);
        persons.put(2, C);
        
        int[][][][] solutions = new int[personCount][personCount][n][n];
        for (int p = 0; p < 3; p++) {
            int p2 = (p + 1) % 3;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int[][] travelTimeP1 = travelTimeStartingAt(i, travelTime, persons.get(p));
                    int[][] travelTimeP2 = travelTimeStartingAt(j, travelTime, persons.get(p2));
                    boolean doesIntersect = doesIntersect(travelTimeP1, travelTimeP2) || doesIntersect(travelTimeP2, travelTimeP1);
                    solutions[p][p2][i][j] = doesIntersect ? 1 : -1;
                    solutions[p2][p][j][i] = doesIntersect ? 1 : -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (solutions[0][1][i][j] == -1 &&
                            solutions[1][2][j][k] == -1 &&
                            solutions[0][2][i][k] == -1
                    ) {
                        System.out.printf("%d %d %d",i+1,j+1, k+1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("impossible");
    }

    private static boolean doesIntersect(int[][] travelTimeP1, int[][] travelTimeP2) {
        for (int i = 0; i < travelTimeP1.length; i++) {
            int arrivalTimeP1 = travelTimeP1[i][0];
            int leaveTimeP1 = travelTimeP1[i][1];
            int arrivalTimeP2 = travelTimeP2[i][0];
            int leaveTimeP2 = travelTimeP2[i][1];
            if (arrivalTimeP1 == arrivalTimeP2) {
                return true;
            }
            if (leaveTimeP1 == leaveTimeP2) {
                return true;
            }
            if (arrivalTimeP1 > arrivalTimeP2 && arrivalTimeP1 < leaveTimeP2) {
                return true;
            }
            if (leaveTimeP1 > arrivalTimeP2 && leaveTimeP1 < leaveTimeP2) {
                return true;
            }
        }
        return false;
    }

    private static int[][] travelTimeStartingAt(int i, int[] travelTime, int[] stayingTime) {
        int n = travelTime.length;
        int[][] newTravelTimes = new int[travelTime.length][2];
        int start = i;
        newTravelTimes[start][0] = 0;
        newTravelTimes[start][1] = stayingTime[start];
        start = (start + 1) % n;
        while (start != i) {
            if (start == 0) {
                newTravelTimes[start][0] = newTravelTimes[n - 1][1] + travelTime[start];
                newTravelTimes[start][1] = newTravelTimes[start][0] + stayingTime[start];
            } else {
                newTravelTimes[start][0] = newTravelTimes[start - 1][1] + travelTime[start];
                newTravelTimes[start][1] = newTravelTimes[start][0] + stayingTime[start];
            }
            start = (start + 1) % n;
        }

        return newTravelTimes;
    }

}
