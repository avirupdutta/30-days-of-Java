package RockPaperScisssor;

import java.util.Random;
import java.util.Scanner;

public class Game {
    //    return a random int from 0 or 1 or 2
    public static int getComputerChoice(){
        Random rand = new Random();
        return rand.nextInt(2);
    }

    public static boolean playerWonRound(String playerChoice, String compChoice){
        if( playerChoice == "Rock" && compChoice == "Scissor" ){
            return true;
        }
        else if( playerChoice == "Paper" && compChoice == "Rock"){
            return true;
        }
        else if ( playerChoice == "Scissor" && compChoice == "Paper" ){
            return true;
        }
        return false;
    }

    public static void main ( String[] args ) {
        Scanner input = new Scanner(System.in);

        User user = new User();
        Configs gameConfigs = new Configs();
        UserSelection selection = new UserSelection();

        user.setUserInfo();
        gameConfigs.setMaxScore();
        int userMenuChoice = 0;
        int userChoice, compChoice;
        String choices[] = gameConfigs.choices;

        while (true){
            gameConfigs.displayMainMenu();
            try{
                userMenuChoice = input.nextInt();
            }
            catch (NumberFormatException e){
                System.out.println("Invalid Input! Choose again\n");
            }
            userChoice = selection.selectOption(userMenuChoice);
            compChoice = getComputerChoice();

            if (playerWonRound(choices[userChoice], choices[compChoice])){
                user.increaseUserScore();
            }else{
                user.decreaseUserScore();
            }
        }
    }
}
