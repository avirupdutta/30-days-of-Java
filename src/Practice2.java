/*
*   Anonymous Class
*
*/

interface Animal{
    void bark();
}
class Dog implements Animal {
    public void bark(){
        System.out.println("Dog is barking");
    }
}
class Babydog extends Dog{
    public void bark(){
        System.out.println("Whooff! Whhooff!!");
    }
}


public class Practice2 {
    public static void main ( String[] args ) {
        /*** Example of why we need Anonymous class ***/
//         General Approach to override a method
//        Dog spike = new Babydog();
//        spike.bark();

//        Overriding a method without any new class declaration
//        Dog spike = new Dog(){
//          public void bark(){
//              System.out.println("Whooff! Whhooff!!");
//          }
//        };
//        spike.bark();
//        Above is the classic example of Anonymous Class

        /*** Example of when we mostly need Anonymous class (with lambda expressions) ***/
        Animal spike = () -> System.out.println("Howwwwwlllll!!!!");
        spike.bark();

//        Note:-
        /*
        *   We can use lambda expressions only with interfaces having 1 abstract method (SAM -> Single Abstract Method) with no body declared in it.
        *
        * Hence we're no longer bound to implement interfaces with (SAM) to a new class just to initialize the SAM's method body
        *
        */



    }
}
