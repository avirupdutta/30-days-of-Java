package LibraryManager;

public class User {
    int limit = 4;
    String[] borrowedBooksId = new String[limit];
    String username = "";
    int countBooks;
    
    User(String name){
        username = name;
        countBooks = 0;
    }
    
    public void borrowNewBook(String id){
        if (countBooks == 4)
            throw new Error("Error: Already borrowed "+limit+" books!");
        countBooks++;
        for (int i = 0; i < limit; i++) {
            if (borrowedBooksId[i] == ""){
                borrowedBooksId[i] = id;
                break;
            }
        }
        System.out.println("You have successfully borrowed the book (ID: "+id+")");
    }
}
