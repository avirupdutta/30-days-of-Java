public class AbstractDemo{
    public static void main(String[] args) {
        // Human obj = new Man();
        // obj.walk();

        Pen parker = new Pen();
        parker.setInkColor("Blue");
        System.out.println(parker.getInkColor());

    }
}

abstract class Human{
    public abstract void eat();
    public abstract void walk();
}

class Man extends Human{
    public void eat(){
        System.out.println("Man is eating");
    }
    public void walk(){
        System.out.println("Man is walking");
    }
}

abstract class Writer{
    public String color;
    public abstract void setInkColor(String color);
    public abstract String getInkColor();
}

class Pen extends Writer{
    public void setInkColor(String color){
        this.color = color;
    }
    public String getInkColor(){
        return this.color;
    }
}


class SketchPen extends Writer{
    public void setInkColor(String color){
        this.color = color;
    }
    public String getInkColor(){
        return this.color;
    }
}

