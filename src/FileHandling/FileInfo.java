package FileHandling;

import java.io.File;

public class FileInfo {
    public static void main ( String[] args ) {
        File myFile = new File("E:\\CODING\\JAVA\\30-days-of-Java\\src\\FileHandling\\test.txt");

        //        checks if the file exists or not
        if (myFile.exists()) {
            System.out.println("Exists: " + myFile.exists());

            //        get the name
            String name = myFile.getName();
            System.out.println("Name: " + name);

            //        checks if the file is readable or not
            if (myFile.canRead())
                System.out.println("Readable: " + myFile.canRead());

            //        checks if the file is writable or not
            if (myFile.canWrite())
                System.out.println("Writable: " + myFile.canWrite());

            //        gets the size of the file
            long size = myFile.length();
            System.out.println("Size (in Bytes): " + size);

        }
        else
            System.out.println("File does not exists");
    }
}
