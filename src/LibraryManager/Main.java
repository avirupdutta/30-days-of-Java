package LibraryManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    static class Admin{
        String username, password;
        Admin(String username, String password){
            this.username = username;
            this.password = password;
        }

        public boolean authenticateAdmin(String uname, String pass){
            return ((username.equals(uname)) && (password.equals(pass)));
        }

        public void displayAllOptions(){
            System.out.println("Press 1 to see list of all books in library");
            System.out.println("Press 2 to add new book to library");
            System.out.println("Press 3 to remove any book from the library");
            System.out.println("Press 4 to see list of all students");
            System.out.println("Press 5 to ban any student from borrowing books");
            System.out.println("Press 6 to permanently delete any student's account");
            System.out.println("Press 0 to logout");
        }
    }

    // store all book objects in this list
    private static ArrayList<Book> allBooks = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

//    Adds a new book into the library
    public static void addNewBookToLibrary(String title, String author, int count) {
        Book newBook = new Book(title, author, count);
        allBooks.add(newBook);
    }

    // Removes a book from library and from all student's account
    public static void removeBookPermanently(Long id, String bookName, String author){
        if (findBook(bookName, author)){
            // pausing the thread for 3 sec
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Removing from Library...");
            for(Book bookObj : allBooks){
                if ((bookObj.uid.equals(id))){
                    allBooks.remove(bookObj);
                }
            }

            // pausing the thread for 3 sec
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Removing from All Students...");
            for(User userObj : allUsers){
                userObj.returnBook(id);
            }
            System.out.println("Book has been removed permanently from the system.");
        }
        else{
            System.out.println("Book is not found in the library");
        }
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

    // checks if the username is unique or not and returns true if the username is available
    public static boolean usernameIsUnique(String uname){
        Boolean flag = true;
        for(User user : allUsers){
            if (user.username.equals(uname)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    // create new account
    public static boolean createNewAccount(String username, String password){
        // create new account only if the username is not taken
        boolean usernameIsAvailable = usernameIsUnique(username);

        if (usernameIsAvailable) {
            User newUser = new User(username, password);
            allUsers.add(newUser);
        }
        return usernameIsAvailable;
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

//    @TODO -> Refactor the entire main()
//    @TODO-> Check for any raised exceptions when user is expected to enter any integer
    public static void main ( String[] args ) {
        Scanner userInput = new Scanner(System.in);
        if (args.length < 2){
            System.out.println("You must provide Username and Password for the Admin");
            System.exit(-1);
        }
        Admin admin = new Admin(args[0], args[1]);
        int input;
        while(true){
            System.out.println("\n============================== MAIN MENU ===========================");
//            @TODO-> Redesign the Admin Panel
            System.out.println("Press 1 for registering new Book to library (Admin)");
            System.out.println("Press 2 for Students");
            System.out.println("Press 0 for exit");
            try {
                input = userInput.nextInt();
                userInput.nextLine(); // clearing the buffer
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! Please Enter a number :(");
                continue;
            }
            if (input == 0)
                break;
            else if (input == 1) {
                // 1. Login to the admin panel after authentication
                // 2. Display all features available for the admin
                System.out.println("\n============================== ADMIN'S MENU ===========================");
                while (true){
                    System.out.println("Press 1 to Login to Admin Panel");
                    System.out.println("Press 9 to go back");
                    System.out.println("Press 0 for exit");
                    int choice = userInput.nextInt();
                    userInput.nextLine(); // clearing the buffer
                    if (choice == 1){
                        System.out.print("Username: ");
                        String adminUsername = userInput.nextLine();
                        System.out.print("Password: ");
                        String adminPassword = userInput.nextLine();

                        boolean adminIsAuth = admin.authenticateAdmin(adminUsername, adminPassword);

                        while (adminIsAuth){
                            admin.displayAllOptions();
                            int adminInput = userInput.nextInt();
                            userInput.nextLine(); // clearing the buffer
                            // displays all books
                            if (adminInput == 1){
                                showAllBooks();
                            }

                            // add new book to library
                            else if (adminInput == 2){
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

                            // remove a book permanently from library using separate thread
                            else if (adminInput == 3){
                                System.out.print("Enter the book id which is to be removed: ");
                                Long id = userInput.nextLong();
                                userInput.nextLine(); // clearing the buffer
                                System.out.print("Enter the book title which is to be removed: ");
                                String bookTitle = userInput.nextLine();
                                System.out.print("Enter the book id which is to be removed: ");
                                String author = userInput.nextLine();

                                Thread t1 = new Thread(new Runnable() {
                                    @Override
                                    public void run () {
                                        removeBookPermanently(id, bookTitle, author);
                                    }
                                });
                                t1.start();
                            }

                            // logout the admin
                            else if (adminInput == 0){
                                adminIsAuth = false;
                            }
                        }
                    }
                    else if (choice == 9){
                        break;
                    }
                    else if (choice == 0){
                        System.out.println("Program has been terminated!");
                        System.exit(0);
                    }
                }

            }
            if (input == 2){
                // borrow new book from library only after authentication
                while(true){
                    System.out.println("\n============================== STUDENT'S MENU ===========================");
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

                            while(loggedInUser != null){
                                System.out.println("================================================================");
                                System.out.println("*****\tAccount for '"+loggedInUser.username+"'\t*****");
                                System.out.println("================================================================");
                                System.out.println("Press 1 to see list of all Books available in library");
                                System.out.println("Press 2 to search for any book's availability");
                                System.out.println("Press 3 to get list of books borrowed by you");
                                System.out.println("Press 4 to borrow a new book");
                                System.out.println("Press 5 to return a book to library");
                                System.out.println("Press 9 to logout");

                                choice = userInput.nextInt();
                                userInput.nextLine(); // clearing the buffer

                                // see list of all Books available in library
                                if (choice == 1){
                                    System.out.println("====== LIST OF ALL BOOKS ======");
                                    showAllBooks();
                                    System.out.println("======= END OF LIST =======");
                                    System.out.println();
                                }

                                // search for any book's availability
                                if (choice == 2){
                                    System.out.print("Enter book name: ");
                                    String bookName = userInput.nextLine();

                                    System.out.print("Enter author name: ");
                                    String author = userInput.nextLine();

                                    if (findBook(bookName, author)){
                                        System.out.println("Your Book is Currently Available");
                                    }
                                    else{
                                        System.out.println("Your Book Not is Currently Available!");
                                    }
                                }

                                // get list of books borrowed by you
                                if (choice == 3){
                                    System.out.println();
                                    loggedInUser.showAllBorrowedBooks();
                                    System.out.println();
                                }

                                // borrow a new book
                                if (choice == 4){
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

                                            // 3. reduce 1 copy of that book from library
                                            updateBookQuantity(bookName, author, -1);
                                        }
                                        catch (ReachedBorrowLimitException | BookIsAlreadyBorrowedException e){
                                            e.printStackTrace();
                                        }
                                        catch (Exception e){
                                            e.printStackTrace();
                                        }

                                    }
                                    else{
                                        System.out.println("\nBook is Currently Unavailable! All copies have been checked out.\n");
                                    }
                                }

                                // return a book to library
                                if (choice == 5){
                                    System.out.print("Enter the id of the book you want to return: ");
                                    Book book = loggedInUser.returnBook(userInput.nextLong());
                                    if(book != null){
                                        updateBookQuantity(book.title, book.author, 1);
                                    }
                                    else{
                                        System.out.println();
                                        System.out.println("ID not Found! You don't have that book to return");
                                        System.out.println();
                                    }
                                }
                                // logout the user
                                if (choice == 9){
                                    System.out.print("Press (Y/n) to logout your Account: ");

                                    String logout = userInput.nextLine().toUpperCase();
                                    if (logout.equals("YES") || logout.equals("Y")){
                                        loggedInUser = null;
                                        System.out.println("You have been successfully logged out of your Account");
                                    }
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
                        boolean flag = true;
                        System.out.println(userInput.nextLine()); // clearing the buffer
                        while(flag){
                            System.out.println("====== CREATING NEW USER ACCOUNT =====");
                            System.out.print("Username: ");
                            String username = userInput.nextLine().strip();

                            if (username.length() >= 2 && username.length() <= 20){
                                System.out.print("Password: ");
                                String password = userInput.nextLine();

                                if (password.length() < 6){
                                    System.out.println("Password must be at least 6 characters long!");
                                    continue;
                                }

                                if(createNewAccount(username, password)){
                                    System.out.println("\nAccount has been created for "+username+"\n");
                                    flag = false;
                                }
                                else{
                                    System.out.println("Error: Could not create new account. Username is already taken!");
                                }
                            }
                            else{
                                System.out.println("Username must be 2 to 20 characters long");
                            }
                        }
                    }
                    else if (choice == 9){
                        // go back to main menu
                        break;
                    }
                    else if (choice == 0){
                        System.out.println("\n======== PROGRAM TERMINATED ========\n");
                        System.exit(0);
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

//        showAllBooks();
    }
}
