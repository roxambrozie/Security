package bruteforce;

public class ThreadsClass implements Runnable {

    StringBuilder stringUsedToMatchPassword = new StringBuilder();
    int min = 32, max = 127;
    long startTime;
    String password;

    public ThreadsClass(String password) {
        this.password = password;
    }

    void loop(int index) {
        //loop in the ascii code  from 32 - 127
        for (int i = min; i < max; i++) {
            stringUsedToMatchPassword.setCharAt(index, (char) i);
            if (index < stringUsedToMatchPassword.length() - 1)
                loop(index + 1);
            System.out.println(stringUsedToMatchPassword);
            if (stringUsedToMatchPassword.toString().equals(password)) {
                System.err.println("Password found: " + stringUsedToMatchPassword);
                System.err.println("It took: " + convertmillis(System.currentTimeMillis() - startTime));
                System.exit(0);
            }
        }
    }

     static String convertmillis(long input) {
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



    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        startTime = System.currentTimeMillis();
        while (true) {
            stringUsedToMatchPassword.append((char) min);

            for (int i = 0; i < stringUsedToMatchPassword.length() - 1; i++) {
                for (int j = min; j < max; j++) {
                    stringUsedToMatchPassword.setCharAt(i, (char) j);
                    loop(i + 1);
                }
            }
        }
    }
}
