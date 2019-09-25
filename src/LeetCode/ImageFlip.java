// Link to the challenge: https://leetcode.com/problems/flipping-an-image/
package LeetCode;
import java.util.Arrays;
public class ImageFlip {
    public static void main ( String[] args ) {
        Solution obj = new Solution();
        int data[][] = {{1,1,0},{1,0,1},{0,0,0}};


        System.out.println(Arrays.toString(obj.flipAndInvertImage(data)));
    }
}
