package FileHandling;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main ( String[] args ) {

        File myFile = new File("E:\\CODING\\JAVA\\30-days-of-Java\\src\\FileHandling\\test.txt");

        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine())
                System.out.println(myReader.nextLine());
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
