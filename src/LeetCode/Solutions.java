package LeetCode;

class Solution{
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

}