package LibraryManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Book> allBooks = new ArrayList<Book>();

    public static void addNewBook(String title, String author, int count) {

        Book newBook = new Book(title, author, count);
        allBooks.add(newBook);
    }

    public static void showAllBooks(){
        for (Book book : allBooks) {
            System.out.println("Id: "+book.uid+" | Title: "+book.title+" | Author: "+book.author+" | Available: "+(book.takenBy == null));
        }
    }

    public static void checkoutLibraryBook(String username){
    }

    public static void main ( String[] args ) {
        Scanner userInput = new Scanner(System.in);
        int input;
        while(true){
            System.out.println("Press 1 for adding new Book to library!");
            System.out.println("Press 0 for exit");

            input = userInput.nextInt();
            if (input == 0)
                break;
            System.out.println();
            userInput.nextLine();
            System.out.print("Enter book title: ");
            String title = userInput.nextLine();
            System.out.print("Enter book author: ");
            String  author = userInput.nextLine();
            System.out.print("Enter Quantity: ");
            addNewBook(title, author, userInput.nextInt());
            System.out.println();
        }


//        addNewBook("My 0th Book", "Abc0");
//        addNewBook("My 1st Book", "Abc1");
//        addNewBook("My 2nd Book", "Abc2");
//        addNewBook("My 3rd Book", "Abc3");
//        addNewBook("My 4th Book", "Abc4");
//        addNewBook("My 5h Book", "Abc5");

        showAllBooks();
    }
}
