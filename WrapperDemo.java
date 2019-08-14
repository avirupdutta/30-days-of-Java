public class WrapperDemo{
    public static void main(String args[]){
        
        int i1 = 5; // Primitive datatype


        Integer i2 = new Integer(10); // Boxing or Wrapping
        int i3 = i2.intValue(); // Unboxing or Unwrapping

        Integer val = i1; // auto Boxing
        int getVal = val; // auto unboxing


        // Parsing string -(to)-> int
        String num = "123";
        int n = Integer.parseInt(num)+2;


        String x = Integer.toString(n)+"xyz";
        System.out.println(x);

    }
}