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
            System.out.println("Press 5 to reset password for students");
            System.out.println("Press 6 to permanently delete any student's account");
            System.out.println("Press 0 to logout");
        }


        // 2. Adds a new book into the library
        public void addNewBookToLibrary(String title, String author, int count) {
            Book newBook = new Book(title, author, count);
            allBooks.add(newBook);
        }

        // 3. Removes a book from library and from all student's account
        public void removeBookPermanently(Long id, String bookName, String author){

            int time = 3000;
            if (findBook(bookName, author, false)){

//                 pausing the thread for "time" secs
                System.out.println("Removing from Library...");
                try{
                    Thread.sleep(time);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                Book bookObj;
                for (int i = 0; i < allBooks.size(); i++) {
                    bookObj = allBooks.get(i);
                    if ((bookObj.uid.equals(id))) {
                        allBooks.remove(bookObj);
                    }
                }

//                 pausing the thread for "time" secs
                System.out.println("Removing from All Students...");
                try{
                    Thread.sleep(time);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                for(User userObj : allUsers){
                    userObj.returnBook(id);
                }
                System.out.println("Book has been removed permanently from the system.");
            }
            else{
                System.out.println("Book is not found in the library");
            }
        }

        // 4. displays all users
        public void showAllUsers(){
            for (User userObj : allUsers) {
                System.out.println("Username: "+userObj.username+" | Total Books: "+userObj.countBooks);
            }
        }

        // 5. reset password of any student
        public boolean resetUserPassword(String username, String newPassword){
            User userObj = findUser(username);
            if (userObj != null){
                userObj.password = newPassword;
                return true;
            }
            return false;
        }

        // 6. permanently delete any student's account
        public boolean removeUserPermanently(String username){
            User userObj = findUser(username);
            if (userObj != null){

                // return all the books that have been borrowed by the user
                for(Book bookObj : userObj.borrowedBooks){
                    updateBookQuantity(bookObj.title, bookObj.author, 1);
                }

                allUsers.remove(userObj);
                return true;
            }
            return false;
        }
    }

    // store all book objects in this list
    private static ArrayList<Book> allBooks = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();


//    displays all the books and their details in the console
    public static void showAllBooks(){
        System.out.println("====== LIST OF ALL BOOKS ======");
        for (Book book : allBooks) {
            System.out.println("Id: "+book.uid+" | Title: "+book.title+" | Author: "+book.author+" | Available: "+(book.totalCount > 0));
        }
        System.out.println("======= END OF LIST =======");
        System.out.println();
    }

//    check if the book actually exits or not in the library
    public static boolean findBook(String bookName, String author, boolean checkCount){
        boolean bookFound = false;

        if (checkCount){
            for (Book book : allBooks) {
                if (book.title.equals(bookName) && book.author.equals(author) && book.totalCount > 0) {
                    bookFound = true;
                    break;
                }
            }
        }
        else{
            for (Book book : allBooks) {
                if (book.title.equals(bookName) && book.author.equals(author)) {
                    bookFound = true;
                    break;
                }
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

    // returns true of student is found in the system
    public static User findUser(String username){
        User user = null;
        for(User userObj : allUsers){
            if (userObj.username.equals(username)){
                user = userObj;
                break;
            }
        }
        return user;
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
            System.out.println("Press 1 for Library Admin");
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
                System.out.println("\n============================== ADMIN AUTHENTICATION ===========================");
                while (true){
                    System.out.println("\nPress 1 to Login to Admin Panel");
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
                            System.out.println("\n============================== ADMIN MENU ===========================");
                            admin.displayAllOptions();
                            int adminInput = userInput.nextInt();
                            userInput.nextLine(); // clearing the buffer
                            // displays all books
                            if (adminInput == 1){
                                showAllBooks();
                            }

                            // add new book to library
                            else if (adminInput == 2){
                                System.out.println("\nHow many books you want to register in the library?");
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

                                    // check if the book is ever registered in the library or not
                                    if(findBook(title, author, false)){
                                        updateBookQuantity(title, author, quantity);
                                    }
                                    else{
                                        admin.addNewBookToLibrary(title, author, quantity);
                                    }
                                    System.out.println();
                                }
                            }

                            // remove a book permanently from library using separate thread
                            else if (adminInput == 3){
                                System.out.println("\n=========== REMOVING BOOK PERMANENTLY ==========");
                                System.out.print("\nEnter Book's Id: ");
                                Long id = userInput.nextLong();
                                userInput.nextLine(); // clearing the buffer
                                System.out.print("Enter Book's Title: ");
                                String bookTitle = userInput.nextLine();
                                System.out.print("Enter Book's Author: ");
                                String author = userInput.nextLine();

                                Thread t1 = new Thread(new Runnable() {
                                    @Override
                                    public void run () {
                                        admin.removeBookPermanently(id, bookTitle, author);
                                    }
                                });
                                t1.start();
                            }

                            // displays list of all students
                            else if (adminInput == 4){
                                System.out.println("\n================= LIST OF ALL STUDENTS =================");
                                admin.showAllUsers();
                                System.out.println("=========================================================\n");
                            }

                            // reset password for students
                            else if (adminInput == 5){
                                System.out.print("Enter the Username: ");
                                String uname = userInput.nextLine();
                                System.out.print("Enter the new Password: ");
                                String newPassword = userInput.nextLine();
                                if (admin.resetUserPassword(uname, newPassword))
                                    System.out.println("Password reset is successful!");
                                else
                                    System.out.println("User not found! Password reset is unsuccessful");
                            }

                            // permanently delete any student's account
                            else if (adminInput == 6){
                                System.out.print("Enter the username of the student to be removed permanently: ");
                                String username = userInput.nextLine();
                                if (admin.removeUserPermanently(username)){
                                    System.out.println(username+" has been permanently removed!");
                                }
                                else{
                                    System.out.println(username+" is not found in the system");
                                }
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
                                    showAllBooks();
                                }

                                // search for any book's availability
                                if (choice == 2){
                                    System.out.print("Enter book name: ");
                                    String bookName = userInput.nextLine();

                                    System.out.print("Enter author name: ");
                                    String author = userInput.nextLine();

                                    if (findBook(bookName, author, true)){
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
                                    if (findBook(bookName, author, true)){
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
    }
}
