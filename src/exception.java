/**
 * exception handling in java
 */
import java.util.Arrays;
public class exception {

    public static void main(String[] args) {
        
        int i=10, j=0, k=0;
        int arr[] = new int[5];
        
        try {
            /**
             * If any error is encountered in try block the rest of the code inside the 
             * try block after that buggy line will not be executed... So keep an eye
             * on the code that might be ignored while an exception
             * is encounterd inside the try block.
             */
            // k = i/j;
            for (int index = 0; index <= arr.length; index++) {
                arr[index] = (index+1)*10;
            }
        } catch (ArithmeticException e) {
            k = 10;
            System.out.println(e+" Error: Cannot divide a nummber by 0");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e+" Error: Recheck the array boundary");
        }
        System.out.println(k);
        System.out.println(Arrays.toString(arr));
    }
}