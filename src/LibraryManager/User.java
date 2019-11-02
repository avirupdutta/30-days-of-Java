package LibraryManager;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    int limit = 4;
    String[] borrowedBooksId = new String[limit];
    ArrayList<Book> borrowedBooks = new ArrayList<Book>();
    String username = "";
    int countBooks;
    
    User(String name){
        username = name;
    }

    private void checkoutNewBook(Book newBook){
        // set the dates
        newBook.dateLastTaken = LocalDate.now();
        newBook.dateOfReturn = LocalDate.now().plusDays(7);

        // add the book to the user's collection
        borrowedBooks.add(newBook);
    }
    
    public boolean borrowNewBook(String bookName, String author) throws Exception {
        boolean pass = true;

        // checks if the user has reached its maximum borrowing limit
        countBooks = borrowedBooks.size();
        if (countBooks == limit){
            pass = false;
            throw new ReachedBorrowLimitException("Already reached borrow "+limit+" of books!");
        }

        // checking if the user has already borrowed the book
        for(Book bookObj : borrowedBooks){
            if (bookObj.title == bookName && bookObj.author == author){
                pass = false;
                throw new BookIsAlreadyBorrowedException("Book has already been borrowed by you!");
            }
        }

        if (pass){
            countBooks++;
            Book newBook = new Book(bookName, author, 1);
            checkoutNewBook(newBook);
        }

        return pass;
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
