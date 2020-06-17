//Implementation of the Gale-Shapley's stable matching algorithm

//Every hospital contains a stack used to implement the preference list. Every hospital pops from the stack
//and obtains a student which they wish to contact with an offer.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class GS {

    //This is the manMarriedToWoman where index i where h_i is the hospital referenced and value at h_i is the student matched
    static int[] manMarriedToWoman;
    static int[] womanMarriedToMan;

    static Map<Map.Entry<Integer, Integer>, Integer> womensPreferences = new HashMap<>();
    static Map<Integer, Object> intToWoman = new HashMap<>();
    static Map<Integer, Object> intToMan = new HashMap<>();
    static Map<Integer, LinkedList<Integer>> mensPreferenceListCollection = new HashMap<>();
    static Queue<Integer> availableMen = new LinkedList<>();


    public static void main(String[] args) throws FileNotFoundException {
        File filePath = new File("C:\\Users\\Mikkel\\Desktop\\AlgorithmDesign\\algdes-labs\\matching\\data\\sm-random-500-in.txt");
        Scanner s = new Scanner(filePath);
        String currentLine;
        int n = 0;
        while (s.hasNext()) {
            currentLine = s.nextLine();
            if (currentLine.startsWith("#")) {
                continue;
            } else if (currentLine.startsWith("n=")) {
                n = Integer.parseInt(currentLine.split("n=")[1]);
                manMarriedToWoman = new int[n]; //This way, we are relieved of some weird indexing issues.
                womanMarriedToMan = new int[n]; //This way, we are relieved of some weird indexing issues.
                for (int i = 0; i < n * 2; i++) {
                    int manOrWoman = s.nextInt() - 1; //We decrease by one because we count from 0
                    Object name = s.nextLine().trim();
                    if (manOrWoman % 2 == 0) {
                        intToMan.put(manOrWoman + 1, name);
                    } else {
                        intToWoman.put(manOrWoman + 1, name);
                    }
                }
                for (int i = 0; i < n * 2; i++) {
                    int manOrWoman = Integer.parseInt(s.next().split(":")[0]) - 1; //We decrease by one because we count from 0
                    LinkedList<Integer> menPreferenceList = new LinkedList<Integer>();
                    for (int j = n; j > 0; j--) {
                        if (manOrWoman % 2 == 0) {
                            int woman = s.nextInt();
                            menPreferenceList.push(woman);
                            if (j == 1) {
                                //If we have looked through all the women, we put the preference list into the collection for men, and add the man as being single.
                                mensPreferenceListCollection.put(manOrWoman+1, menPreferenceList);
                                availableMen.add(manOrWoman+1);
                            }
                        } else {
                            //Women just need to assert whether they want to accept the man, so, we keep their manOrWoman index (their id), the mans id (s.nextInt), and their value
                            //where value is j. That is why we start with j = n, and decrement j for each iteration. We get the most valued men first, and therefore it's easier to count down.
                            womensPreferences.put(new SimpleEntry<>(manOrWoman + 1, s.nextInt()), j);
                        }
                    }
                }
            }
        }
        while (!availableMen.isEmpty()) {
            int man = availableMen.poll();
            int manIndex = ((man+1)/2)-1;
            LinkedList<Integer> preferenceList = mensPreferenceListCollection.get(man);
            int woman = preferenceList.pollLast();
            int womanIndex = (woman/2)-1;
            /**
            if (manMarriedToWoman[woman] == 0) {
                manMarriedToWoman[woman] = man;
            } else if (manMarriedToWoman[woman] != 0) {
                int newHospitalPreference = womensPreferences.get(new SimpleEntry(woman, man));
                int oldHospitalPreference = womensPreferences.get(new SimpleEntry<>(woman, manMarriedToWoman[woman]));
                if (newHospitalPreference > oldHospitalPreference) {
                    availableMen.add(manMarriedToWoman[woman]);
                    manMarriedToWoman[woman] = man;
                } else {
                    availableMen.add(man);
                }
            }
             **/
            if (womanMarriedToMan[womanIndex] == 0) {
                manMarriedToWoman[manIndex] = woman;
                womanMarriedToMan[womanIndex] = man;

            } else if (womanMarriedToMan[womanIndex] != 0) {
                int newHospitalPreference = womensPreferences.get(new SimpleEntry(woman, man));
                int oldHospitalPreference = womensPreferences.get(new SimpleEntry<>(woman, womanMarriedToMan[womanIndex]));
                if (newHospitalPreference > oldHospitalPreference) {
                    availableMen.add(womanMarriedToMan[womanIndex]);
                    womanMarriedToMan[womanIndex] = man;
                    manMarriedToWoman[manIndex] = woman;
                } else {
                    availableMen.add(man);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (manMarriedToWoman[i] != 0) {
                System.out.println(intToMan.get(i*2+1) + " -- " + intToWoman.get(manMarriedToWoman[i]));
            }
        }

    }
}