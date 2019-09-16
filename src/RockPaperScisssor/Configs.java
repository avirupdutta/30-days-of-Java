package RockPaperScisssor;

public class Configs {
    public static int scoreUpdateDiff = 5;
    public static String choices[] = new String[]{"Rock", "Paper", "Scissor"};
    public static int winningScore;

    public static void setWinningScore(int maxScore){
        winningScore = maxScore;
    }
}
