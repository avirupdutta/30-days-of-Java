/**
 * DefaultMethodDemo
 * 
 * Advantage of Default method is that it allows us 
 * to define a method inside an interface which can be used as a regular
 * method by the object created from the implemented class!
*/

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Demo obj = new DemoImp();
        obj.abc();
        obj.show();
    }
}

@FunctionalInterface
interface Demo {
    void abc(); // This is actually "public abstract void abc()"
    default void show(){
        System.out.println("In Demo interface");
    }
}
class DemoImp implements Demo{
    public void abc(){
        System.out.println("In abc of DemoImp");
    }
}