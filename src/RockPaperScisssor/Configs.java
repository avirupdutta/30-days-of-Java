package RockPaperScisssor;

import java.util.Scanner;

public class Configs {
    Scanner input = new Scanner(System.in);
    public static int scoreUpdateDiff = 5, maxScore;
    public String choices[] = new String[]{"Rock", "Paper", "Scissor"};

    public void displayMainMenu(){
        System.out.println("Press 1 to Start Playing");
        System.out.println("Press 2 to Exit\n");
    }
    public void setMaxScore(){ maxScore = input.nextInt(); }
    public void displayChoices(){
        System.out.println("\nChoose Your Option\n");
        for(int i = 0; i < choices.length; i++){
            System.out.println((i+1)+". "+choices[i]);
        }
    }
}
