package codewars;

public class MiddleCharacter {
    public static String getMiddle(String word) {
        //Code goes here!

//        Checking if word length is odd
        if (word.length() % 2 != 0)
            return String.valueOf(word.charAt((int)Math.ceil(word.length() / 2)));
        else
            return String.valueOf(word.charAt((word.length() / 2)-1)) + String.valueOf(word.charAt(word.length() / 2));

    }
}
