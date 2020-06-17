import java.util.*;

public class Timezones {
    static Map<String, Double> timeZones = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Double>("GMT", 0.),
            new AbstractMap.SimpleEntry<String, Double>("BST", 1.),
            new AbstractMap.SimpleEntry<String, Double>("IST", 1.),
            new AbstractMap.SimpleEntry<String, Double>("UTC", 0.),
            new AbstractMap.SimpleEntry<String, Double>("WEST", 1.),
            new AbstractMap.SimpleEntry<String, Double>("CET", 1.),
            new AbstractMap.SimpleEntry<String, Double>("CEST", 2.),
            new AbstractMap.SimpleEntry<String, Double>("WET", 0.),
            new AbstractMap.SimpleEntry<String, Double>("EET", 2.),
            new AbstractMap.SimpleEntry<String, Double>("EEST", 3.),
            new AbstractMap.SimpleEntry<String, Double>("MSK", 3.),
            new AbstractMap.SimpleEntry<String, Double>("MSD", 4.),
            new AbstractMap.SimpleEntry<String, Double>("AST", -4.),
            new AbstractMap.SimpleEntry<String, Double>("ADT", -3.),
            new AbstractMap.SimpleEntry<String, Double>("NST", -3.5),
            new AbstractMap.SimpleEntry<String, Double>("NDT", -2.5),
            new AbstractMap.SimpleEntry<String, Double>("EST", -5.),
            new AbstractMap.SimpleEntry<String, Double>("EDT", -4.),
            new AbstractMap.SimpleEntry<String, Double>("CST", -6.),
            new AbstractMap.SimpleEntry<String, Double>("CDT", -5.),
            new AbstractMap.SimpleEntry<String, Double>("MST", -7.),
            new AbstractMap.SimpleEntry<String, Double>("MDT", -6.),
            new AbstractMap.SimpleEntry<String, Double>("PST", -8.),
            new AbstractMap.SimpleEntry<String, Double>("PDT", -7.),
            new AbstractMap.SimpleEntry<String, Double>("HST", -10.),
            new AbstractMap.SimpleEntry<String, Double>("AKST", -9.),
            new AbstractMap.SimpleEntry<String, Double>("AKDT", -8.),
            new AbstractMap.SimpleEntry<String, Double>("AEST", 10.),
            new AbstractMap.SimpleEntry<String, Double>("AEDT", 11.),
            new AbstractMap.SimpleEntry<String, Double>("ACST", 9.5),
            new AbstractMap.SimpleEntry<String, Double>("ACDT", 10.5),
            new AbstractMap.SimpleEntry<String, Double>("AWST", 8.)
    );

    public static void main(String[] args) {
        //Load in test..

        printANewTime("HST", "CEST", "noon", "midnight");
        printANewTime("EST", "GMT", "11:29 a.m.", "4:29 p.m.");
        printANewTime("CST", "UTC", "6:01 p.m.", "12:01 a.m.");
        printANewTime("ADT", "MSK", "12:40 p.m.", "6:40 p.m.");
        printANewTime("ACST", "ACDT", "noon", "1:00 p.m.");
        printANewTime("ACDT", "ACST", "11:59 p.m.", "10:59 p.m.");
        Scanner scan = new Scanner(System.in);
        int argsNo = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < argsNo; i++) {
            String[] argsForComp = scan.nextLine().split(" ");
            if (argsForComp.length == 3) {
                String from = argsForComp[1];
                String to = argsForComp[2];
                printANewTime(from, to, argsForComp[0], null);
            }
            else {
                String from = argsForComp[2];
                String to = argsForComp[3];
                String amPm = argsForComp[1];
                printANewTime(from, to, argsForComp[0] + " " + amPm, null);
            }
        }
    }
    private static void printANewTime (String from, String to, String time, String expected){
        if (!from.equals(to)) {
            double timeZone = calculateTimeZone(from, to);
            int timeInMinutes = convertToMinutes(time);
            double result = ((double) timeInMinutes) + timeZone;
            while (result < 0) {
                result = 720 + result;
            }
            if (expected != null) {
                System.out.println(("Time was: " + convertToClock(result) + ". Expected: " + expected + ". Test passed? " + convertToClock(result).equals(expected)));
            } else {
                System.out.println(convertToClock(result));
            }
        }
        else {
            System.out.println(time);
        }
    }
    private static int convertToMinutes(String time) {
        int timeInMinutes = 0;
        String[] hourDividedAmPm = time.split(" ");
        String AmOrPm = "a.m.";
        try {
            AmOrPm = hourDividedAmPm[1];
            String[] clock = hourDividedAmPm[0].split(":");
            timeInMinutes = Integer.parseInt(clock[0]) * 60 + Integer.parseInt(clock[1]);
        } catch (Exception e) {
            switch (time) {
                case "noon":
                    //12:00*60
                    timeInMinutes = 720;
                    break;
                case "midnight":
                    //00:00*60
                    timeInMinutes = 0;
                    break;
                default:
                    throw e;
            }
        }
        switch (AmOrPm) {
            case "a.m.":
            case "A.M.":
                return timeInMinutes;
            case "p.m.":
            case "P.M.":
                //If it is PM, we only forward after 12:00pm - e,g after 780 minutes.
                if (timeInMinutes > 780) {
                    return timeInMinutes + 720;
                }
                else return timeInMinutes;
        }
        return timeInMinutes;
    }

    private static double calculateTimeZone(String from, String to) {
        double fromTimezone = timeZones.get(from);
        double toTimeZone = timeZones.get(to);
        if (fromTimezone > toTimeZone || (fromTimezone < toTimeZone && fromTimezone < 0 && toTimeZone < 0)) {
            if (fromTimezone < 0 && toTimeZone < 0) {
                return convertToMinutes(Math.abs(fromTimezone) - Math.abs(toTimeZone));
            }
            else if (fromTimezone > 0 && toTimeZone > 0) {
                return -convertToMinutes(Math.abs(fromTimezone) - Math.abs(toTimeZone));
            }
            return convertToMinutes(Math.abs(fromTimezone) + Math.abs(toTimeZone));
        }
        if ((fromTimezone < 0 && toTimeZone < 0) || (fromTimezone > 0 && toTimeZone > 0)) {
            return convertToMinutes(Math.abs(toTimeZone) - Math.abs(fromTimezone));
        }
        return convertToMinutes(Math.abs(timeZones.get(from)) + Math.abs(timeZones.get(to)));

    }
    private static double calculateTimeZone(double from, double to) {
        if (from > to) {
            return convertToMinutes(Math.abs(from) - Math.abs(to));
        } else {
            return convertToMinutes(Math.abs(from) + Math.abs(to));
        }
    }

    private static double convertToMinutes(double time) {
        return time * 60.;
    }

    private static String convertToClock(double time) {
        time = time % 1440;
        int minutes = (int) Math.round((time / 60 - Math.floor(time / 60)) * 60);
        int hours = (int) Math.floor(time / 60);
        if (hours == 12 && minutes == 0) {
            return "noon";
        } else if (hours == 0 && minutes == 0) {
            return "midnight";
        } else if (hours > 12) {
            hours = hours - 12;
            return hours + ":" + (minutes < 10 ? "0" +String.valueOf(minutes) : minutes) + " p.m.";
        } else {
            if (hours == 0) {
                hours += 12;
            }
            return hours + ":" + (minutes < 10 ? "0" +String.valueOf(minutes) : minutes) + " a.m.";
        }
    }
}
