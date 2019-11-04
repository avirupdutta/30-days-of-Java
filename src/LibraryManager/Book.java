package LibraryManager;

import java.time.LocalDate;
import java.util.Date;

public class Book{
    Long uid;  // stores the unique id based upon system time
    int totalCount;  // stores how many books are available
    String title, author, takenBy;  // detailed info about the book and the user's name
    LocalDate dateLastTaken, dateOfReturn;  // stores the info about date range

    Book(String bookTitle, String authorName, int quantity) {
        uid = new Date().getTime();
        title = bookTitle;
        author = authorName;
        totalCount = quantity;
        takenBy = null;
        dateLastTaken = null;
        dateOfReturn = null;
    }
    Book(Long id, String bookTitle, String authorName, int quantity, String username) {
        uid = id;
        title = bookTitle;
        author = authorName;
        totalCount = quantity;
        takenBy = username;
        dateLastTaken = LocalDate.now();
        dateOfReturn = LocalDate.now().plusDays(7);
    }
}