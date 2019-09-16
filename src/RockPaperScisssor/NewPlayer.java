package RockPaperScisssor;

public class NewPlayer {
    public String name;
    public int score = 0;

    //    increase / decrease user score
    public void increaseScore(){
        score += Configs.scoreUpdateDiff;
    }
    public void decreaseScore(){
        score -= Configs.scoreUpdateDiff;
    }
    public boolean reachedMaxScore() { return score >= Configs.winningScore; }

    public int getScore(){
        return score;
    }
}
