package bruteforce;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadFromFile read = new ReadFromFile();
        String password = read.readFromFileReturnString();
        System.out.println(password);

        Thread t = new Thread(new ThreadsClass(password), "First Thread ");
       // Thread t1 = new Thread(new ThreadsClass(password), "Second Thread");
      //  Thread t2 = new Thread(new ThreadsClass(password), "Third Thread");
        t.start();
//        t1.start();
//        t2.start();

    }
}
