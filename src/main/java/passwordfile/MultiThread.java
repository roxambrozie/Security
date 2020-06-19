//package passwordfile;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static passwordfile.BruteForceTest.bruteForceMethod;
//
//public class MultiThread implements Runnable {
//
//    static BufferedReader br = null;
//    static List<String> list;
//
//    static {
//        try {
//            br = new BufferedReader(new FileReader("D:\\Security repo\\Security\\src\\main\\java\\passwordfile\\data.txt"), 10);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void run() {
//        String line = null;
//        int count = 0;
//        while (true) {
//                 System.out.println(Thread.currentThread().getName());
//            this.list = new ArrayList<String>();
//            synchronized (br) {
//                try {
//                    while ((line = br.readLine()) != null) {
//                        if (count < 15) {
//                            list.add(line);
//                            count++;
//                        } else {
//                            list.add(line);
//                            count = 0;
//                            break;
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                Thread.sleep(1);
//                display(this.list);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (line == null)
//                break;
//        }
//        bruteForceMethod();
//    }
//
//    public static void display(List<String> list) {
//        for (String str : list) {
//            System.out.println(str);
//        }
//        System.out.println("The number of passwords in the list is: " + list.size());
//    }
//
//}
