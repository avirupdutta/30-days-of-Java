package RockPaperScisssor;

import java.util.Random;
import java.util.Scanner;

public class User {
    public String name;
    public int score;

    public void setUserInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        name = input.nextLine();
    }

//    increase / decrease user score
    public void increaseUserScore(){
        score += Configs.scoreUpdateDiff;
    }
    public void decreaseUserScore(){
        score -= Configs.scoreUpdateDiff;
    }

    public int getScore(){
        return score;
    }
}
