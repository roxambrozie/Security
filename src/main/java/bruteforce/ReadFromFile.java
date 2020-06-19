package bruteforce;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFromFile {
    BufferedReader br = null;
    String passwordFromFile;

    String readFromFileReturnString() throws IOException {
        try {
            br = new BufferedReader(new FileReader("D:\\Security repo\\Security\\src\\main\\java\\passwordfile\\data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        passwordFromFile = br.readLine();
        return passwordFromFile;
    }

    void readFromFileReturnList() throws IOException {

        Path pathToPasswordFile = Paths.get("D:\\Security repo\\Security\\src\\main\\java\\passwordfile\\data.txt");
        List<String> passwords = Files.readAllLines(pathToPasswordFile);
        System.out.println(passwords);
    }


}
