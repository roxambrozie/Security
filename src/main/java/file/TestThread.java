package passwordfile;

import java.io.IOException;

public class TestThread {

    public static void main(String args[]) throws IOException {






        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();

        R1.readFromFile();
    }
}
