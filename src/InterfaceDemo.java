//public class InterfaceDemo {
//    public static void main(String args[]){
//
//        Kit myKit = new Kit();
//        Pen p = new Pen();
//        Pencil pc = new Pencil();
//        myKit.doSomething(pc);
//
//
//    }
//}
//class Tools{
//    public void write(int a){
//        System.out.println("I am a tool");
//    }
//}
//
//interface Writer{
//    void write();
//}
//
//class Pen extends Tools implements Writer{
//    public void write(){
//        System.out.println("I am Pen");
//    }
//}
//
//class Pencil extends Tools implements Writer{
//    public void write(){
//        System.out.println("I am Pencil");
//    }
//}
//
//class Kit{
//    void doSomething(Writer p){
//        p.write();
//    }
//}
//
//
