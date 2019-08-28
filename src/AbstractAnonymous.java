/**
 * AbstractAnonymous
 */
public class AbstractAnonymous {
    public static void main(String[] args) {
        Abc myObj = new Abc(){
            public void show(){
                System.out.println("I am abstract anonymous class");
            }
        };
        myObj.show();
    }
    
}
interface Abc{
    void show();
}

