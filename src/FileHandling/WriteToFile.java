package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main ( String[] args ) {
        try {
            FileWriter writer = new FileWriter("E:\\CODING\\JAVA\\30-days-of-Java\\src\\FileHandling\\test.txt");
            writer.write("I am learning Java!");
            System.out.println("File writing successful!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
