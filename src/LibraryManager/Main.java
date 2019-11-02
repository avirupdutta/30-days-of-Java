package LibraryManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // store all book objects in this list
    private static ArrayList<Book> allBooks = new ArrayList<Book>();

//    Adds a new book into the library
    public static void addNewBookToLibrary(String title, String author, int count) {
        Book newBook = new Book(title, author, count);
        allBooks.add(newBook);
    }

//    displays all the books and their details in the console
    public static void showAllBooks(){
        for (Book book : allBooks) {
            System.out.println("Id: "+book.uid+" | Title: "+book.title+" | Author: "+book.author+" | Available: "+(book.takenBy == null));
        }
    }

//    check if the book actually exits or not in the library
    public static boolean findBook(String bookName, String author){
        boolean bookFound = false;
        for (Book book : allBooks) {
            if (book.title == bookName && book.author == author) {
                bookFound = true;
                break;
            }
        }
        return  bookFound;
    }

//    if the book is already present in the library then just
//    increment the quantity when the admin tries to add more books
//    with same book name and author name
    public static void updateBookQuantity(String bookName, String author, int num){
        for(Book bookObj : allBooks){
            if (bookObj.title == bookName && bookObj.author == author){
                bookObj.totalCount += num;
                break;
            }
        }
        System.out.println(bookName+" quantity has been updated!");
    }

    public static void main ( String[] args ) {
        Scanner userInput = new Scanner(System.in);
        int input;
        while(true){
            System.out.println("Press 1 for registering new Book to library!");
            System.out.println("Press 2 for borrowing a book.");
            System.out.println("Press 0 for exit");
            input = userInput.nextInt();

            if (input == 0)
                break;
            else if (input == 1) {
                System.out.println("How many books you want to register in the library?");
                int num = userInput.nextInt();
                for (int i = 0; i < num; i++){
//                   simple user input for development purposes
                    System.out.println();
                    userInput.nextLine();
                    System.out.print("Enter book title: ");
                    String title = userInput.nextLine();
                    System.out.print("Enter book author: ");
                    String author = userInput.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = userInput.nextInt();

                    // check if the book is already present in the library or not
                    if(findBook(title, author)){
                        updateBookQuantity(title, author, quantity);
                    }
                    else{
                        addNewBookToLibrary(title, author, quantity);
                    }
                    System.out.println();
                }
            }
            if (input == 2){
                // borrow new book from library only after authentication
            }
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
