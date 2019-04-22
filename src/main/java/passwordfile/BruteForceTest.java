package passwordfile;

import java.util.List;

import static passwordfile.MultiThread.display;

public class BruteForceTest implements Runnable {

    static String password = "aab";
   // static List<String> password = MultiThread.list;
    static StringBuilder string = new StringBuilder();
    static int min = 32, max = 127;
    static long start;

    public static void loop(int index) {
        for (int i = min; i < max; i++) {
            string.setCharAt(index, (char) i);
            if (index < string.length() - 1)
                loop(index + 1);
            System.out.println(string);
            if (string.toString().equals(password)) {
                System.err.println("Password found: " + string);
                System.err.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                System.exit(0);
            }
        }
    }

    public static String convertmillis(long input) {
        int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;

        int day = 86400000;
        int hour = 3600000;
        int minute = 60000;
        int second = 1000;

        if (input >= day) {
            days = (int) (input / day);
            millis = (int) (input % day);
        } else
            millis = (int) input;

        if (millis >= hour) {
            hours = millis / hour;
            millis = millis % hour;
        }

        if (millis >= minute) {
            minutes = millis / minute;
            millis = millis % minute;
        }

        if (millis >= second) {
            seconds = millis / second;
            millis = millis % second;
        }

        return (days + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
    }


    public static void bruteForceMethod() {
        start = System.currentTimeMillis();
        while (true) {
            string.append((char) min);

            for (int i = 0; i < string.length() - 1; i++) {
                for (int j = min; j < max; j++) {
                    string.setCharAt(i, (char) j);
                    loop(i + 1);
                }
            }
        }
    }

    @Override
    public void run() {
//        start = System.currentTimeMillis();
//        while (true) {
//            string.append((char) min);
//
//            for (int i = 0; i < string.length() - 1; i++) {
//                for (int j = min; j < max; j++) {
//                    string.setCharAt(i, (char) j);
//                    loop(i + 1);
//                }
//            }
//        }
    }
}


