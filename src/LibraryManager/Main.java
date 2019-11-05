package LibraryManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // store all book objects in this list
    private static ArrayList<Book> allBooks = new ArrayList<Book>();
    private static ArrayList<User> allUsers = new ArrayList<>();

//    Adds a new book into the library
    public static void addNewBookToLibrary(String title, String author, int count) {
        Book newBook = new Book(title, author, count);
        allBooks.add(newBook);
    }

//    displays all the books and their details in the console
    public static void showAllBooks(){
        for (Book book : allBooks) {
            System.out.println("Id: "+book.uid+" | Title: "+book.title+" | Author: "+book.author+" | Available: "+(book.totalCount > 0));
        }
    }

//    check if the book actually exits or not in the library
    public static boolean findBook(String bookName, String author){
        boolean bookFound = false;
        for (Book book : allBooks) {
            if (book.title.equals(bookName) && book.author.equals(author) && book.totalCount > 0) {
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
            if (bookObj.title.equals(bookName) && bookObj.author.equals(author)){
                bookObj.totalCount += num;
                break;
            }
        }
        System.out.println(bookName+" quantity has been updated!");
    }

    // create new account
    public static boolean createNewAccount(String username, String password){
        // create new account only if the username is not taken
        boolean usernameAvailable = true;
        for(User userObj : allUsers){
            if (userObj.username.equals(username)){
                usernameAvailable = false;
                break;
            }
        }
        if (usernameAvailable) {
            User newUser = new User(username, password);
            allUsers.add(newUser);
        }
        return usernameAvailable;
    }

    // login old user
    public static User loginUser(String username, String password){
        User foundUser = null;
        for(User userObj : allUsers){
            if (userObj.username.equals(username) && userObj.password.equals(password)){
                foundUser = userObj;
                break;
            }
        }
        return foundUser;
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
                while(true){
                    System.out.println("Press 1 for Login");
                    System.out.println("Press 2 to Create new Account");
                    System.out.println("Press 9 for previous menu");
                    System.out.println("Press 0 to exit");

                    int choice = userInput.nextInt();

                    if (choice == 1){
                        // login
                        System.out.println("====== LOGIN YOUR ACCOUNT =====");
                        System.out.println(userInput.nextLine()); // clearing the buffer
                        System.out.print("Username: ");
                        String username = userInput.nextLine();
                        System.out.print("Password: ");
                        String password = userInput.nextLine();

                        // stores the obj of logged in user
                        User loggedInUser = loginUser(username, password);

                        if (loggedInUser != null){
                            // login successful
                            System.out.println("Logged in successfully!");

                            while(loggedInUser != null){
                                System.out.println();
                                System.out.println("====== LIST OF ALL BOOKS ======");
                                showAllBooks();
                                System.out.println("======= END OF LIST =======");
                                System.out.println();

                                System.out.print("Enter book name: ");
                                String bookName = userInput.nextLine();

                                System.out.print("Enter author name: ");
                                String author = userInput.nextLine();

                                System.out.print("Enter book id: ");
                                Long bookId = userInput.nextLong();
                                userInput.nextLine(); // clearing the buffer for '\n'

                                // check if the book is actually present in the library or not
                                if (findBook(bookName, author)){
                                    try {
                                        // 0. if the user already have reached borrow limit then don't give another one
                                        // 1. if the user already have that book then don't give another one
                                        // 2. otherwise add 1 book to the user's collection
                                        loggedInUser.borrowNewBook(bookId, bookName, author);
                                    }
                                    catch (ReachedBorrowLimitException | BookIsAlreadyBorrowedException e){
                                        e.printStackTrace();
                                    }
                                    catch (Exception e){
                                        e.printStackTrace();
                                    }

                                    // 3. reduce 1 copy of that book from library
                                    updateBookQuantity(bookName, author, -1);
                                }
                                else{
                                    System.out.println("\nBook is Currently Unavailable! All copies have been checked out.\n");
                                }
                                System.out.print("Press (Y/n) to logout your Account: ");
                                char logout = userInput.nextLine().toUpperCase().charAt(0);
                                if (logout == 'Y'){
                                    loggedInUser = null;
                                    System.out.println("You have been successfully logged out of your Account");
                                }
                            }
                        }
                        else{
                            // login failed
                            System.out.println();
                            System.out.println("Login Failed: Invalid username or password");
                            System.out.println();
                        }
                    }
                    else if (choice == 2){
                        // sign up
                        System.out.println("====== CREATING NEW USER ACCOUNT =====");
                        System.out.println(userInput.nextLine()); // clearing the buffer
                        System.out.print("Username: ");
                        String username = userInput.nextLine();
                        System.out.print("Password: ");
                        String password = userInput.nextLine();

                        if(createNewAccount(username, password)){
                            System.out.println("Account has been created for "+username);
                        }
                        else{
                            System.out.println("Error: Could not create new account. Username is already taken!");
                        }
                    }
                    else if (choice == 9){
                        // go back to main menu
                        break;
                    }
                    else if (choice == 0){
                        // @TODO -> stop the program immediately
                    }
                }
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
