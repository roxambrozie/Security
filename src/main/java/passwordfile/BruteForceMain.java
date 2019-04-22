package passwordfile;

public class MultiThreadMain {

    public static void main(String[] args) {

        Thread t = new Thread(new MultiThread(), "A");
        Thread t1 = new Thread(new BruteForceTest(), "B");
        Thread t2 = new Thread(new BruteForceTest(), "C");
        t.start();
        t1.start();
        t2.start();



    }
}
