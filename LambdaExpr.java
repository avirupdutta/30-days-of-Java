/**
 * Interface:-
 * 1) Normal (with multiple method declarations)
 * 2) Single Abractract Method (SAM)
 * 3) Mark Interface (interfaces with no method declarations--> e.g: Serialize)
 * 
 * Lambda Expression works with *SAM only! 
 */

/**
 * LambdaExpression, Abstract-Anonymous class
 */
public class LambdaExpr {

    public static void main(String[] args) {
        ABC myObj = () -> System.out.println("I am Lambda Expression");
        myObj.show();

        Dog spike = () -> System.out.println("Whoff! Whoff! Whoff!!!");
        spike.bark();
    }
    
}
interface ABC{
    void show();
};

interface Dog{
    void bark();
}

