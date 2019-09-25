package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public int fib(int N){
        if (N == 1)
            return 1;
        else if (N == 2)
            return 1;
        else if (N <= 0)
            return 0;
        return fib(N-1)+fib(N-2);
    }
    public int numJewelsInStones ( String jewels, String stones ) {
        int counter = 0;
        for (int i = 0; i < jewels.length(); i++){
            for (int j = 0; j < stones.length(); j++){
                if (stones.charAt(j) == jewels.charAt(i))
                    counter++;
            }
        }
        return counter;
    }
    public String longestWord(String[] words) {
        String output = "";
        for (String word: words){
            if (word.length() > output.length())
                output = word;
        }
        return output;
    }
    private int[] reverseArray(int arr[]){
        int newArr[] = new int[arr.length];
        for (int i=arr.length-1, j=0; i>=0; i--, j++)
            newArr[j] = arr[i];
        return newArr;
    }
    public int[][] flipAndInvertImage(int[][] A) {
//        flipping horizontally
        for (int i = 0; i < A.length; i++)
            A[i] = reverseArray(A[i]);

//        Inverting it
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                if (A[i][j] == 1)
                    A[i][j] = 0;
                else
                    A[i][j] = 1;
            }
        }
        return A;
    }
    public int[] sortArrayByParity(int[] A) {
        int output[] = new int[A.length];

        int lastIndex = 0;
        // pushing all the even elements first
        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0)
                output[lastIndex++] = A[i];
        }

        // finally pushing all the odd elements
        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 != 0)
                output[lastIndex++] = A[i];
        }

        return output;
    }
    public int repeatedNTimes(int[] A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int num: A){
            if (arr.contains(num))
                return num;
            arr.add(num);
        }
        return -1;
    }
    public String defangIPaddr(String address) {
        String output = "";

        for (int i = 0; i < address.length(); i++){
            char currChar = address.charAt(i);
            if ( currChar == '.'){
                output += "[.]";
            }else{
                output += currChar;
            }
        }
        return output;
    }
    private int countDigits(int num){
        int counter = 0;
        while (num > 0){
            num = num / 10;
            counter++;
        }
        return counter;
    }
    private boolean checkSelfDivision(int num){
        boolean output = false;
        int numCopy = num;
        while (num > 0){
            int lastDigit = num % 10;
            if (lastDigit == 0 || numCopy % lastDigit != 0){
                output = false;
                break;
            }
            else{
                output = true;
            }
            num = num / 10;
        }
        return output;
    }
    public List<Integer> selfDividingNumbers( int left, int right) {
        List<Integer> output = new ArrayList<Integer>();

        for (int i = left; i <= right ; i++){
            if (checkSelfDivision(i))
                output.add(i);
        }

        return output;
    }
    public boolean checkPerfectNumber(int num) {
        int counter = 0;
        if (num == counter)
            return true;
        for (int i = 1; i <= num / 2; i++){
            if ( num % i == 0 )
                counter += i;
        }
        System.out.println(counter);
        return num == counter;
    }
    public int integerReplacement(int n) {
//        Buggy method
//        Link to the problem - https://leetcode.com/problems/integer-replacement/
        int counter = 0;
        while (n > 1){
            System.out.print(n+" ");
            if (n % 2 == 0)
                n /= 2;
            else
                n = (n + 1);
            counter++;

        }
        return counter;
    }
    public int hammingDistance(int x, int y) {
        int counter = 0;
        String binX = Integer.toBinaryString(x);
        String binY = Integer.toBinaryString(y);

        int binXlen = binX.length();
        int binYlen = binY.length();

        if (binXlen > binYlen){
            int diff = binXlen - binYlen;
            for (int i = 0; i < diff; i++){
                binY = "0" + binY;
            }
            binYlen = binY.length();
        }
        else if (binYlen > binXlen){
            int diff = binYlen - binXlen;
            for (int i = 0; i < diff; i++){
                binX = "0" + binX;
            }
            binXlen = binX.length();
        }
        for (int i = 0; i < binXlen; i++){
            if (binX.charAt(i) != binY.charAt(i)){
                counter++;
            }
        }
        return counter;
    }
}








