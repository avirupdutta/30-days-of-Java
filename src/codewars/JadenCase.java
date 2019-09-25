package codewars;

public class JadenCase {
    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if(phrase == null || phrase == "")
            return null;
        String wordsArr[] = phrase.split(" ");
        for (int i=0; i < wordsArr.length; i++){
            wordsArr[i] = String.valueOf(wordsArr[i].charAt(0)).toUpperCase() + wordsArr[i].substring(1);
        }
        String output = "";
        for(String word: wordsArr){
            output += " "+word;
        }
        return output.strip();
    }
}
