package LibraryManager;

import java.time.LocalDate;
import java.util.Date;

public class Book{
    Long uid;
    int totalCount;
    String title, author, takenBy;
    LocalDate dateLastTaken, dateOfReturn;

    Book(String bookTitle, String authorName, int quantity) {
        uid = new Date().getTime();
        title = bookTitle;
        author = authorName;
        totalCount = quantity;
        takenBy = null;
        dateLastTaken = null;
        dateOfReturn = null;
    }

    public void checkout (String username) {
        takenBy = username;
        dateLastTaken = LocalDate.now();
        dateOfReturn = LocalDate.now().plusDays(7);
    }
}