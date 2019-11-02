interface Demo{
    int i = 9;
    void abc();
    static void show(){
        System.out.println("In show");
    }
}
class DemoImplementor implements Demo{
    public void abc(){
        // It will throw an error if "i" is reassigned
//        i = 10;
        System.out.println(i);
    }
}

public class StaticMethodInterface {
    public static void main ( String[] args ) {
        Demo.show();
        Demo obj = new DemoImplementor();
        obj.abc();
    }

}
