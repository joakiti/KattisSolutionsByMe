package adv_algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class left_to_right_minima {

    public static void main(String[] args) throws IOException {
        runTests();
    }

    private static void runTests() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
        float iteartionAmount = 100.f;
        LinkedList<Float> averageCountLeftRight = new LinkedList<>();
        for (int count = 1 ; count < 10000; count++) {
            int minimaCount = 0;
            for (int i = 0; i < iteartionAmount; i++) {
                float[] vals = generateFloats(count, i);
                minimaCount += findLeftRightMinimas(vals).size();
            }
            averageCountLeftRight.add(minimaCount/iteartionAmount);
        }
        for (int i = 0; i < averageCountLeftRight.size(); i++) {
            writer.write(String.format("%f\n", averageCountLeftRight.poll()));
        }
        writer.close();

    }

    private static float[] generateFloats(int count, long seed) {
        Random r = new Random(seed);
        float[] vals = new float[count];

        for (int i = 0; i < vals.length; i++) {
            vals[i] = r.nextFloat() / Float.MAX_VALUE;
        }
        return vals;
    }

    private static  List<Float> findLeftRightMinimas(float[] vals) {
        List<Float> minimals = new ArrayList<>();
        float currentMin = vals[0];
        minimals.add(currentMin);
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] < currentMin) {
                currentMin = vals[i];
                minimals.add(currentMin);
            }
        }
        return minimals;
    }

}
