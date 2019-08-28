interface Demo{
    void abc();
    default void show(){
        System.out.println("in Demo interface");
    }
}
interface MyDemo{
    default void show(){
        System.out.println("in MyDemo interface");
    }
}

class DemoImp implements Demo, MyDemo{
    public void abc(){
        System.out.println("in abc of DemoImp");
    }
//    1st process
//    public void show(){
//        System.out.println("in show of DemoImp");
//    }
//    2nd process
    @Override
    public void show(){
        MyDemo.super.show();
    }
}


public class MultipleInheritanceIssues {
    public static void main ( String[] args ) {
        DemoImp obj = new DemoImp();
        obj.abc();
        obj.show();
    }
}
