package LibraryManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    int limit = 4;
//    String[] borrowedBooksId = new String[limit];
    ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    final String username;
    String password;
    int countBooks;
    
    User(String name, String pass){
        username = name;
        password = pass;
    }

    public void borrowNewBook(Long bookId, String bookName, String author) throws Exception {
        boolean pass = true;

        // checks if the user has reached its maximum borrowing limit
        reachedBorrowLimit();

        // checking if the user has already borrowed the book
        alreadyHaveTheBook(bookName, author);

        // if no exception arises the user is authorized to borrow
        Book newBook = new Book(bookId, bookName, author, 1, username);

        // add the book to the user's collection
        borrowedBooks.add(newBook);
        countBooks = borrowedBooks.size();
    }

    // removes a book from the user's collection
    public Book returnBook(Long bookId){
        Book book = null;
        for(Book bookObj : borrowedBooks){
            if (bookObj.uid.equals(bookId)){
                book = bookObj;
                borrowedBooks.remove(bookObj);
                break;
            }
        }
        return book;
    }

    public void showAllBorrowedBooks(){
        if (borrowedBooks.size() == 0){
            System.out.println("Your list of books is Empty! Try borrowing new books");
        }
        for (Book book : borrowedBooks) {
            System.out.println("Id: "+book.uid+" | Title: "+book.title+" | Author: "+book.author+" | Date of Return: "+book.dateOfReturn);
        }
    }


    // check if the user  has already reached the borrow limit or not
    private void reachedBorrowLimit () throws ReachedBorrowLimitException {
        // checks if the user has reached its maximum borrowing limit
        int countBooks = borrowedBooks.size();
        if (countBooks == limit){
            throw new ReachedBorrowLimitException("Already reached borrow "+limit+" of books!");
        }
    }

    // Already have the book
    private void alreadyHaveTheBook ( String bookName, String author ) throws BookIsAlreadyBorrowedException{
        // checking if the user has already borrowed the book
        for(Book bookObj : borrowedBooks){
            if (bookObj.title.equals(bookName) && bookObj.author.equals(author)){
                throw new BookIsAlreadyBorrowedException("Book has already been borrowed!");
            }
        }
    }
}

class ReachedBorrowLimitException extends Exception{
    public ReachedBorrowLimitException(String s){
        super(s);
    }
}

class BookIsAlreadyBorrowedException extends Exception{
    public BookIsAlreadyBorrowedException(String s){
        super(s);
    }
}
